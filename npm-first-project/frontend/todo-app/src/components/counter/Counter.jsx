import './Counter.css';
import { useState } from 'react';
import CounterButton from './CounterButton';

export default function Counter(){
    const [count, setCount] = useState(0);
    function incrementCounterParentFunction(by){
        setCount(count+by)
    }
    function decrementCounterParentFunction(by){
        setCount(count-by)
    }
    function resetFunction(){
        setCount(0)
    }
    return(
        <>
            <span className="totalCount">{count}</span>
            <CounterButton by={1} incrementFunction={incrementCounterParentFunction} decrementFunction={decrementCounterParentFunction}/>
            <CounterButton by={2} incrementFunction={incrementCounterParentFunction} decrementFunction={decrementCounterParentFunction}/>
            <CounterButton by={5} incrementFunction={incrementCounterParentFunction} decrementFunction={decrementCounterParentFunction}/>
            <button className='resetButton' onClick={resetFunction}>Reset</button>
        </>
    )
}