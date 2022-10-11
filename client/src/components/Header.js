import React from 'react';
import { Routes, Route, Link, useNavigate, Outlet } from 'react-router-dom';
import styled from 'styled-components';
import font from '../styles/font';
import Responsive from '../components/common/Responsive'

let Box = styled(Responsive)`
  width: 100%;
  height: 50px;
  padding: 8px;
  background-color: white;
  /* border-bottom: 2px solid red; */
  position: fixed;
  z-index: 100;
  display: flex;
  justify-content: space-around;
  align-items: center;
  border: none;
  /* outline: 1px solid red; */
`;

let LogoBox = styled.div`
  width: 100px;
  height: 45px;
  margin: 1px;
  font-weight: 500;
  font-size: large;
  display: flex;
  justify-content: center;
  align-items: center;
  /* background: url('./pumkinlogo.png'); */
  border: 1px solid #7e30d1;
  border-radius: 10px;
  &:hover {
    color: #f0be29;
    cursor: pointer;
  }
`;
let LoginBox = styled.div`
  width: 300px;
  height: 50px;
  display: flex;
  justify-content: center;
  align-items: center;
  &:hover {
    color: #f0be29;
    cursor: pointer;
  }
`;
let Button = styled.button`
  //로그인/회원가입버튼
  width: 120px;
  height: 30px;
  display: flex;
  align-items: center;
  justify-content: center;
  text-shadow: 1px 1px 3px #666666;
  color: white;
  margin: 1em;
  padding: 0.25em 1em;
  border-radius: 28px;
  background: #7d45a8;
  text-decoration: none;
  /* border: 1px solid solid #7e30d1; */
  border: none;
  outline: 1px solid #7d45a8;
  &:hover {
    color: #f0be29;
    cursor: pointer;
  }
`;
// const OpenButton = styled(Button)`
//   //방만들기버튼
//   font-weight: 700;
// `;


function Header() {
  let navigate = useNavigate();
  return (
    <Box>
      <LogoBox
        onClick={() => {
          navigate('/');
        }}
      >
        {/* <img src="url(./pumkinlogo.png)" alt="Logo" /> */}
        호박공구마
      </LogoBox>
      <LoginBox>
        <Button
          onClick={() => {
            navigate('/write');
          }}
        >
          <font.H4>방만들기</font.H4>
        </Button>
        <Button
          onClick={() => {
            navigate('/login');
          }}
        >
          <font.H4>로그인</font.H4>
        </Button>
        <Button
          onClick={() => {
            navigate('/register');
          }}
        >
          <font.H4>회원가입</font.H4>
        </Button>
      </LoginBox>
    </Box>
  );
}

export default Header;
