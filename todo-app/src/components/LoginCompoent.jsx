import { useState } from "react";
import { useNavigate} from "react-router-dom";
import { useAuth } from "./security/AuthContext";
function Login(){
    const [username, setUsername] = useState("ram");
    const [password, setPassword] = useState("password")
    const [showErrorMessage, setshowErrorMessage] = useState(false)
    const navigate = useNavigate()
    const authContext = useAuth()
    function handleUsernameChange(event){
        setUsername(event.target.value)
    }
    function handlePasswordChange(event){
        setPassword(event.target.value)
    }
    function handleSubmit(){
        if (authContext.login(username,password)){
            navigate(`/Welcome/${username}`)
        }
        else{
            setshowErrorMessage(true)
        }
    }
    return(
        <>
        <h1>Time to login!</h1>
        <div className="LoginComponent">
            {showErrorMessage && <div className="errorMessage">Authentication Failed</div>}
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
export default Login;