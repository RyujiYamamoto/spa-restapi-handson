import React from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import './App.css';
import { Login } from './components/Login';
import { NavigationHeader } from './components/NavigationHeader';
import { Signup } from './components/Signup';
import { TodoBoard } from './components/TodoBoard';
import { Welcome } from './components/Welcome';

function App() {
  return (
    <BrowserRouter>
      <NavigationHeader />
      <Switch>
        <Route exact path='/board'>
          <TodoBoard />
        </Route>
        <Route exact path='/signup'>
          <Signup />
        </Route>
        <Route exact path='/login'>
          <Login />
        </Route>
        <Route exact path='/'>
          <Welcome />
        </Route>
      </Switch>
    </BrowserRouter>
  );
}

export default App;
