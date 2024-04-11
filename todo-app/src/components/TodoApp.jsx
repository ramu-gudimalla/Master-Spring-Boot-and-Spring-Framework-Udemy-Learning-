import { BrowserRouter,Routes,Route} from "react-router-dom";
import "./TodoApp.css"
import HeaderComponent from "./HeaderComponent";
import WelcomeComponent from "./WelcomeComponent";
import ListTodosComponent from "./ListTodosComponent";
import LogoutComponent from "./LogoutComponent";
import ErrorComponent from "./ErrorComponent";
import Login from "./LoginCompoent";
export default function TodoApp(){
    return(
        <>
            <div className="TodoApp">
                <BrowserRouter>
                    <HeaderComponent/>
                    <Routes>
                        <Route path="/" element={<Login/>}></Route>
                        <Route path="/login" element={<Login/>}></Route>
                        <Route path="/welcome/:username" element={<WelcomeComponent/>}/>
                        <Route path="/todos" element={<ListTodosComponent/>}/>
                        <Route path="/logout" element={<LogoutComponent/>}/> 
                        <Route path="*" element={<ErrorComponent/>}/>
                    </Routes>
                </BrowserRouter>
            </div>
        </>
    )
}



