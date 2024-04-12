import axios from "axios";
// export function  retrieveHelloWorldBean(){
//     return axios.get('http://localhost:8080/say-hello-bean')
// }

const apiClient = axios.create(
    {
        baseURL:'http://localhost:8080'
    }
)

export const retrieveHelloWorldBean = ()=> apiClient.get('/say-hello-bean')
export const retrieveHelloWorldPathVariable = (username) => apiClient.get(`/hello-world/path-variable/${username}`)