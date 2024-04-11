function ListTodosComponent(){
    const today = new Date()
    const targetDate = new Date(today.getFullYear()+2, today.getMonth(), today.getDay)
    const todos = [
        {id:1, descrption: "Learn Spring Framework", done:false, targetDate:targetDate},
        {id:2, descrption: "Learn AWS",done:false, targetDate:targetDate},
        {id:3, descrption: "Learn Docker",done:false, targetDate:targetDate}
    ]
    return(
        <div className="container">
            <h1>Todos shown here!</h1>
            <div>
                <table className="table">
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
export default ListTodosComponent;