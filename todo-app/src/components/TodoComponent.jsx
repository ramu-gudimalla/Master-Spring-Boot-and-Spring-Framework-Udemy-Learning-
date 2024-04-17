import { useNavigate, useParams } from "react-router-dom"
import { createTodoApi, retrieveTodoApi, updateTodoApi } from "./api/TodoAPIService"
import { useAuth } from "./security/AuthContext"
import { useEffect, useState } from "react"
import { Formik, Form, Field, ErrorMessage } from "formik"

export default function TodoComponent(){
    const {id} = useParams()
    const authContext = useAuth()
    const username = authContext.username
    const [description,setDescription] = useState('')
    const [targetDate,setTargetDate] = useState('')
    const navigate = useNavigate()
    function retrieveTodos(){
        if(id !== -1){
            retrieveTodoApi(username,id)
                .then((response)=>{
                    setDescription(response.data.description)
                    setTargetDate(response.data.targetDate)
                })
            .catch((error)=>console.log(error))
        }
    }
    useEffect(
        ()=>retrieveTodos,[id]
    )
    function onSubmit(values){
        const todo = {
            id : id,
            username: username,
            description: values.description,
            targetDate: values.targetDate,
            done:false
        }
        if(id === -1){
            createTodoApi(username,todo)
            .then(response=>{
                navigate('/todos')
            })
            .catch((errors)=>console.log(errors))
        }else{
            updateTodoApi(username,id,todo)
                .then(response=>{
                    navigate('/todos')
                })
                .catch((errors)=>console.log(errors))
    
            console.log(todo)
        }
    }
    function validate(values){
        let errors = {
            // description: "Enter a valid description",
            // targetDate: "Enter a valid targetDate"
        }
        if(values.description.length<5){
            errors.description ="Description should be more than 5 characters"
        }
        if(values.targetDate === null || values.targetDate === "" ){
            errors.targetDate = 'Enter a target date'
        }
        console.log("valiate ",values)
        return errors
    }
    return(
        <div className="container">
            <h1>Enter Todo details!</h1>
            <div>
                <Formik initialValues={{description,targetDate}} enableReinitialize={true} onSubmit={onSubmit} validate={validate} 
                    validateOnChange={false} validateOnBlur={false}>
                    {
                        (props) => (
                            <Form>
                                <ErrorMessage
                                    name="description"
                                    component="div"
                                    className="alert alert-warning"
                                />
                                <ErrorMessage
                                    name="targetDate"
                                    component="div"
                                    className="alert alert-warning"
                                />
                                <fieldset className="form-group">
                                    <label>Description</label>
                                    <Field type="text" className="form-control" name="description"></Field>
                                </fieldset>
                                <fieldset className="form-group">
                                    <label>Target Date</label>
                                    <Field type="date" className="form-control" name="targetDate"></Field>
                                </fieldset>
                                <div>
                                    <button className="btn btn-success m-5" type="submit">Save</button>
                                </div>
                            </Form>
                        )
                    }
                </Formik>
            </div>
        </div>
    )
}