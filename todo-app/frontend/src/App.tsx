import React from 'react';
import './App.css'
import { NavigationHeader } from './components/NavigationHeader';
import { TodoBoard } from './components/TodoBoard';

function App() {
  return (
    <React.Fragment>
      <NavigationHeader/>
      <TodoBoard />
    </React.Fragment>
  );
}

export default App;
