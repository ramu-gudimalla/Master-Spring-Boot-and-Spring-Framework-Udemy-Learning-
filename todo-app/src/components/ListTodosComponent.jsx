import { useEffect, useState } from "react";
import { retrieveAllTodoForUsernameApi, deleteTodoApi } from "./api/TodoAPIService";
import { useAuth } from "./security/AuthContext";
import { useNavigate } from "react-router-dom";

function ListTodosComponent(){
    const [todos,setTodos] = useState([])
    const [message,setMessage] =useState(null)
    const authContext = useAuth()
    const username = authContext.username
    const navigate = useNavigate()
    useEffect(
        ()=> refreshTodo(),[]
    )
    function refreshTodo(){
        retrieveAllTodoForUsernameApi(username)
            .then(response=>{
                setTodos(response.data)
            })
            .catch(error=>console.log(error))
    }
    function deleteTodo(id){
        deleteTodoApi(username,id)
            .then(()=>{
                setMessage(`Delete Operation is success for id= ${id}`)
                refreshTodo()
            }
            )
            .catch(error=>console.log(error))
    }
    function updateTodo(id){
        navigate(`/todo/${id}`)
    }
    
    return(
        <div className="container">
            <h1>Things you want to do!</h1>
            <div className="alert alert-warning">{message}</div>
            <div>
                <table className="table">
                    <thead>
                        <tr>
                            <th>Description</th>
                            <th>Is Done?</th>
                            <th>Target Date</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        {todos.map(
                            todo=>(
                                <tr key={todo.id}>
                                    {/* <td>{todo.id}</td> */}
                                    <td>{todo.description}</td>
                                    <td>{todo.done.toString()}</td>
                                    {/* <td>{todo.targetDate.toDateString()}</td> */}
                                    <td>{todo.targetDate.toString()}</td>
                                    <td><button className="btn btn-danger" onClick={()=>deleteTodo(todo.id)}>Delete</button></td>
                                    <td><button className="btn btn-success" onClick={()=>updateTodo(todo.id)}>Update</button></td>
                                </tr>
                            )
                        )}
                    </tbody>
                </table>
            </div>
        </div>
    )
}
export default ListTodosComponent;