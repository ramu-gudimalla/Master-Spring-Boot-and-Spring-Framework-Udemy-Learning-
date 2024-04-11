import { useState } from "react";
import { useNavigate} from "react-router-dom";
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
export default Login;