import { useParams, Link } from "react-router-dom";
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
export default WelcomeComponent;