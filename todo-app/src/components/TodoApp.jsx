import { BrowserRouter,Routes,Route, Navigate} from "react-router-dom";
import "./TodoApp.css"
import HeaderComponent from "./HeaderComponent";
import WelcomeComponent from "./WelcomeComponent";
import ListTodosComponent from "./ListTodosComponent";
import LogoutComponent from "./LogoutComponent";
import ErrorComponent from "./ErrorComponent";
import Login from "./LoginCompoent";
import AuthProvider, { useAuth } from "./security/AuthContext"
export default function TodoApp(){

    function AuthenticatedRoute({children}){
        const authContext = useAuth()
        if(authContext.isAuthenticated)
            return children
        return <Navigate to="/"/>
    }

    return(
        <>
            <div className="TodoApp">
                <AuthProvider>
                    <BrowserRouter>
                        <HeaderComponent/>
                        <Routes>
                            <Route path="/" element={<Login/>}></Route>
                            <Route path="/login" element={<Login/>}></Route>
                            <Route path="/welcome/:username" element={
                                <AuthenticatedRoute>
                                    <WelcomeComponent/>
                                </AuthenticatedRoute>
                            }/>
                            <Route path="/todos" element={
                                <AuthenticatedRoute>
                                    <ListTodosComponent/>
                                </AuthenticatedRoute>
                            }/>
                            <Route path="/logout" element={
                                <AuthenticatedRoute>
                                    <LogoutComponent/>
                                </AuthenticatedRoute>
                            }/> 
                            <Route path="*" element={<ErrorComponent/>}/>
                        </Routes>
                    </BrowserRouter>
                </AuthProvider>
            </div>
        </>
    )
}



