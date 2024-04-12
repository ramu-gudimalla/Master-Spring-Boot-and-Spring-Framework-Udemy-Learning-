import { createContext, useContext, useState } from "react";

// 1: Create context
export const AuthContext = createContext()

export const useAuth = () => useContext(AuthContext)

// 2. Share the created context with other components
export default function AuthProvider({ children }){
    
    //Put some state in the context
    const [isAuthenticated, setAuthenticated] = useState(false)
    const [username,setUsername] = useState(null)

    function login(username,password){
        if (username === 'ram' && password === 'password'){
            setUsername(username)
            setAuthenticated(true)
            return true
        } else{
            setAuthenticated(false)
            setUsername(null)
            return false
        }
    }
    function logout(){
        setAuthenticated(false)
    }

    return(
        <AuthContext.Provider value={ { isAuthenticated, login, logout, username } }>
            {children}
        </AuthContext.Provider>
    )
}