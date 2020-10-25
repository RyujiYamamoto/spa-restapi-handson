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

  return (
    <div className='TodoBoard_content'>
      <TodoForm addTodo={addTodo} />
      <TodoFilter />
      <TodoList todos={todos} />
    </div>
  );
};
