import { createSlice } from '@reduxjs/toolkit'

const initialState = {
    key: ""
}

export const keyReducer = createSlice({
    name: 'keyReducer',
    initialState,
    reducers: {
        getKey: (state) => {
            console.log("get çalıştı");
            console.log(state);
            console.log(state.key);
            return state.key;
        },
        setKey: (state, action) => {
            state.key = ""
            state.key += action.payload
            console.log("action.payload: " + action.payload);
            console.log("state.key:      " + state.key);
        }
    },
})

export const { getKey, setKey } = keyReducer.actions
export default keyReducer.reducer