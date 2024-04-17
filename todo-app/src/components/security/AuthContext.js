import { createContext, useContext, useState } from "react";
import { executeJwtAuthenticationService } from "../api/AuthenticationApiService";
import { apiClient } from "../api/ApiClient";

// 1: Create context
export const AuthContext = createContext()

export const useAuth = () => useContext(AuthContext)

// 2. Share the created context with other components
export default function AuthProvider({ children }){
    
    //Put some state in the context
    const [isAuthenticated, setAuthenticated] = useState(false)
    const [username,setUsername] = useState(null)
    const [token,setToken] = useState(null)

    // async function login(username,password){
    //     const basicAuthToken = 'Basic '+ window.btoa(username+":"+password)
    //     try{
    //         const response = await executeBasicAuthenticationService(basicAuthToken)
    //         if (response.status === 200){
    //             setUsername(username)
    //             setAuthenticated(true)
    //             setToken(basicAuthToken)

    //             apiClient.interceptors.request.use(
    //                 (config) => {
    //                     console.log('intercepting and a token')
    //                     config.headers.Authorization=basicAuthToken
    //                     return config
    //                 }
    //             )

    //             return true
    //         } else{
    //             logout()
    //             return false
    //         }   
    //     }catch(errors){
    //         logout()
    //         return false
    //     }
    // }
    async function login(username,password){
        try{
            const response = await executeJwtAuthenticationService(username,password)
            const jwtToken = 'Bearer '+response.data.token
            if (response.status === 200){
                setUsername(username)
                setAuthenticated(true)
                setToken(jwtToken)

                apiClient.interceptors.request.use(
                    (config) => {
                        console.log('intercepting and a token')
                        config.headers.Authorization=jwtToken
                        return config
                    }
                )

                return true
            } else{
                logout()
                return false
            }   
        }catch(errors){
            logout()
            return false
        }
    }
    function logout(){
        setToken(null)
        setUsername(null)
        setAuthenticated(false)
    }

    return(
        <AuthContext.Provider value={ { isAuthenticated, login, logout, username, token } }>
            {children}
        </AuthContext.Provider>
    )
}