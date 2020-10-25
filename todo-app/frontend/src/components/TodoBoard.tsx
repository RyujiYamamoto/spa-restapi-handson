import React, { useEffect, useState } from 'react';
import { BackendService } from '../backend/BackendService';
import './TodoBoard.css';
import { TodoFilter } from './TodoFilter';
import { TodoForm } from './TodoForm';
import { TodoList } from './TodoList';

type Todo = {
  id: number;
  text: string;
  completed: boolean;
};

export const TodoBoard: React.FC = () => {
  const [todos, setTodos] = useState<Todo[]>([]);

  useEffect(() => {
    BackendService.getTodos().then((response) => setTodos(response));
  }, []);

  const addTodo = (returnedTodo: Todo) => {
    setTodos(todos.concat(returnedTodo));
  };

  const toggleTodoCompletion = (id: number) => {
    const target = todos.find((todo) => todo.id === id);
    if (!target) {
      return;
    }
    BackendService.putTodo(id, !target.completed).then((returnedTodo) => setTodos(todos.map((todo) => (todo.id === id ? returnedTodo : todo))));
  };

  return (
    <div className='TodoBoard_content'>
      <TodoForm addTodo={addTodo} />
      <TodoFilter />
      <TodoList todos={todos} toggleTodoCompletion={toggleTodoCompletion} />
    </div>
  );
};
