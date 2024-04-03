import {PropTypes} from 'prop-types'
export default function CounterButton({by, incrementFunction, decrementFunction}){    
    // function incrementCounterFunction(){
    //     incrementFunction(by)
    // }
    // function decrementCounterFunction(){
    //     decrementFunction(by)
    // }
    return (
        <div className="Counter">
            <div>
                <button className="counterButton" onClick={()=>incrementFunction(by)}>+{by}</button>
                <button className='counterButton' onClick={()=>decrementFunction(by)}>-{by}</button>
            </div>
        </div>
    );
}

CounterButton.propTypes = {
    by: PropTypes.number
  }
  CounterButton.defaultProps ={
    by:1
  }