import { configureStore } from '@reduxjs/toolkit'
import counterReducer from './redux-example/CounterReducer'
import keyReducer from './reducer/KeyReducer'

export const store = configureStore({
  reducer: {
    counter: counterReducer,
    key: keyReducer
  },
})

