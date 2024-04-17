// import axios from "axios";
// export function  retrieveHelloWorldBean(){
//     return axios.get('http://localhost:8080/say-hello-bean')
// }
import { apiClient } from "./ApiClient"
export const retrieveHelloWorldBean = ()=> apiClient.get('/say-hello-bean')
export const retrieveHelloWorldPathVariable = (username,token) => apiClient.get(`/hello-world/path-variable/${username}`,{
    headers:{
        Authorization: token
    }
})
export const executeBasicAuthenticationService = (token) => apiClient.get(`/basicAuth`,{
    headers:{
        Authorization: token
    }
})