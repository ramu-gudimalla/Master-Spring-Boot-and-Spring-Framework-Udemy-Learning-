// import axios from "axios";
import { apiClient } from "./ApiClient";
// export function  retrieveHelloWorldBean(){
//     return axios.get('http://localhost:8080/say-hello-bean')
// }

export const retrieveAllTodoForUsernameApi = (username) => apiClient.get(`/users/${username}/todos`)
export const deleteTodoApi = (username,id) => apiClient.delete(`/users/${username}/todos/${id}`)
export const retrieveTodoApi = (username,id) => apiClient.get(`/users/${username}/todos/${id}`)
export const updateTodoApi = (username,id,todo) => apiClient.put(`/users/${username}/todos/${id}`,todo)
export const createTodoApi = (username,todo) => apiClient.put(`/users/${username}/todos`,todo) 