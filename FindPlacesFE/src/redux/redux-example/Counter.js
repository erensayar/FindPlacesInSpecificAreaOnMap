import React, { useState } from 'react';
import { useSelector, useDispatch } from 'react-redux'
import { decrement, increment, incrementByAmount } from './CounterReducer'

const Counter = () => {

    const count = useSelector((state) => state.counter.value)
    const dispatch = useDispatch()
    const [inp, setInp] = useState();

    return (
        <div>
            <div>
                <button className="btn-sm btn-primary mx-2" onClick={() => dispatch(increment())}>Increment</button>
                <span>{count}</span>
                <button className="btn-sm btn-primary mx-2" onClick={() => dispatch(decrement())}>Decrement</button>
                <input onChange={(e) => setInp(e.target.value)} />
                <button className="btn-sm btn-primary" onClick={() => dispatch(incrementByAmount(inp))}>Increment With Val</button>
            </div>
        </div>
    )

}

export default Counter