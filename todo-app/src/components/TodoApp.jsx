import { useState } from "react"
import { BrowserRouter,Routes,Route,useNavigate,useParams, Link } from "react-router-dom";
import "./TodoApp.css"
export default function TodoApp(){
    return(
        <>
            <div className="TodoApp">
                <BrowserRouter>
                    <Routes>
                        <Route path="/" element={<Login/>}></Route>
                        <Route path="/login" element={<Login/>}></Route>
                        <Route path="/welcome/:username" element={<WelcomeComponent/>}/>
                        <Route path="/todos" element={<ListTodosComponent/>}/>
                        <Route path="*" element={<ErrorComponent/>}/>
                    </Routes>
                </BrowserRouter>
            </div>
        </>
    )
}

function Login(){
    const [username, setUsername] = useState("ram");
    const [password, setPassword] = useState("password")
    const [showSuccessMessage, setshowSuccessMessage] = useState(false)
    const [showErrorMessage, setshowErrorMessage] = useState(false)
    const navigate = useNavigate()
    function handleUsernameChange(event){
        setUsername(event.target.value)
    }
    function handlePasswordChange(event){
        setPassword(event.target.value)
    }
    function handleSubmit(){
        if (username === 'ram' && password === 'password'){
            console.log("success")
            setshowSuccessMessage(true)
            setshowErrorMessage(false)
            navigate(`/Welcome/${username}`)
        }
        else{
            console.log("failed")
            setshowSuccessMessage(false)
            setshowErrorMessage(true)
        }
    }
    // function SuccessMessageComponent(){
    //     if(showSuccessMessage){
    //         return <div className="successMessage" >Authentication Success</div>
    //     }
    //     return null
    // }
    // function ErrorMessageComponent(){
    //     if(showErrorMessage){
    //         return <div className="errorMessage">Authentication Failed</div>
    //     }
    //     return null
    // }
    return(
        <>
        <h1>Time to login!</h1>
        <div className="LoginComponent">
            {showSuccessMessage && <div className="successMessage" >Authentication Success</div>}
            {showErrorMessage && <div className="errorMessage">Authentication Failed</div>}
            {/* <SuccessMessageComponent/> */}
            {/* <ErrorMessageComponent/> */}
            <div className="loginForm">
                <label>User Name</label>
                <input type="text" name="username" value={username} onChange={handleUsernameChange}/>
            </div>
            <div>
                <label>Password</label>
                <input type="password" name="password" value={password} onChange={handlePasswordChange}/>
            </div>
            <div>
                <button type="button" name="login" onClick={handleSubmit}>Login</button>
            </div>
        </div>
        </>
    )
}

function WelcomeComponent(){
    const {username} = useParams()
    console.log(username)
    return(
        <>
        <h1>Welcome {username}</h1>
        <div className="WelcomeComponent">
            Manage your todos- <Link to="/todos">Click here</Link> 
        </div>
        </>
    )
}
function ErrorComponent(){
    return(
        <div className="ErrorComponent">
            <h1>We are working really hard!</h1>
            <div>
                Apologies for 404. Please reach our team at xyz@mail.com.
            </div>
        </div>
    )
}
function ListTodosComponent(){
    const today = new Date()
    const targetDate = new Date(today.getFullYear()+2, today.getMonth(), today.getDay)
    const todos = [
        {id:1, descrption: "Learn Spring Framework", done:false, targetDate:targetDate},
        {id:2, descrption: "Learn AWS",done:false, targetDate:targetDate},
        {id:3, descrption: "Learn Docker",done:false, targetDate:targetDate}
    ]
    return(
        <div className="ListTodosComponent">
            <h1>Todos shown here!</h1>
            <div>
                <table>
                    <thead>
                        <tr>
                            <td>Id</td>
                            <td>Description</td>
                            <td>isDone</td>
                            <td>TargetDate</td>
                        </tr>
                    </thead>
                    <tbody>
                        {todos.map(
                            todo=>(
                                <tr key={todo.id}>
                                    <td>{todo.id}</td>
                                    <td>{todo.descrption}</td>
                                    <td>{todo.done.toString()}</td>
                                    <td>{todo.targetDate.toDateString()}</td>
                                </tr>
                            )
                        )}
                    </tbody>
                </table>
            </div>
        </div>
    )
}