import './App.css';
import React from 'react';
import { Route, Routes } from 'react-router-dom';
import PostListPage from './pages/PostListPage';
import LoginPage from './pages/LoginPage';
import RegisterPage from './pages/RegisterPage';
import WritePage from './pages/WritePage';
import PostPage from './pages/PostPage';
import RegisterInfo from './pages/RegisterInfo';
import { createGlobalStyle } from 'styled-components';
import GlobalStyle from './styles/Globalstyle'


function App() {
  return (
    <>
      <Routes>
        <Route path="/" element={<PostListPage />} />
        <Route path="/:id" element={<PostListPage />} />
        <Route path="/post" element={<PostListPage />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/register" element={<RegisterPage />} />
        <Route path="/regiInfo" element={<RegisterInfo />} />
        <Route path="/write" element={<WritePage />} />
        <Route path="/post/:id" element={<PostPage />} />
        <Route path="*" element={ <div>없는 페이지 입니다.</div> } />
      </Routes>
    </>
  );
}

export default App;
