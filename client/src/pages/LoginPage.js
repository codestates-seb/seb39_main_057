import React, { useState, useEffect } from 'react';
import styled from 'styled-components';
import Header from '../components/Header';
import Footer from '../components/Footer';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import font from '../styles/font';

let PaddingBox = styled.div`
  height: 60px;
`;
const Background = styled.div`
  width: 100%;
  height: auto;
  margin-top: 50px;
  display: flex;
  justify-content: center;
  /* border: 1px solid red; */
`;
const ContentsBox = styled.div`
  width: 400px;
  height: 500px;
  padding-left: 30px;
  padding-top: 30px;
  border-radius: 3px;
  border: none;
  outline: 1px solid hsl(210, 8%, 75%);
`;
const TitleZone = styled.div`
  width: 80%;
  height: 15%;
  padding: 10px 20px;
  /* border: 1px solid blue; */
`;
const LoginInfoBox = styled.div`
  width: 80%;
  height: 45%;
  padding-left: 20px;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  /* border: 1px solid red; */
`;
const InputBox = styled.input`
  width: 300px;
  height: 25px;
  padding: 4.5px;
  border-radius: 3px;
  border: none;
  outline: 1px solid hsl(210, 8%, 75%);
`;
const CheckZone = styled.div`
  width: 300px;
  height: 50px;
  padding: 4.5px;
  margin-bottom: 20px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  /* border: 1px solid blue; */
  > div {
    display: flex;
    justify-content: space-between;
    font-size: 13px;
    margin-right: 10px;
  }
`;
const ButtonZone = styled(TitleZone)`
  height: 20%;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;
  /* border: 1px solid purple; */
`;
const LoginButton = styled.button`
  width: 150px;
  height: 60px;
  display: flex;
  align-items: center;
  justify-content: center;
  text-shadow: 1px 1px 3px #666666;
  color: white;
  margin: 1em;
  padding: 0.5em 1em;
  border-radius: 25px;
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
const KaKaoLogin = styled(LoginButton)`
  background: #f0be29;
  outline: none;
  &:hover {
    color: #7d45a8;
    cursor: pointer;
  }
`;

function LoginPage({ setIsLogin, setUserInfo }) {
  // const [Email, setEmail] = useState('');
  // const [Password, setPassword] = useState('');
  const navigate = useNavigate();
  const [loginInfo, setLoginInfo] = useState({
    userId: '',
    password: '',
  });
  const [checkedKeepLogin, setCheckedKeepLogin] = useState(false);
  const [errorMessage, setErrorMessage] = useState('');
  const SignIn = () => {
    navigate('/');
  };
  const handleInputValue = (key) => (e) => {
    setLoginInfo({ ...loginInfo, [key]: e.target.value });
  };
  const loginRequestHandler = () => {
    // Login 컴포넌트가 가지고 있는 state를 이용해 로그인을 구현합니다.
    // 로그인에 필요한 유저정보가 충분히 제공되지 않았다면 에러메시지가 나타남
    console.log(loginInfo);

    if (!loginInfo.userId || !loginInfo.password) {
      setErrorMessage('아이디와 비밀번호를 입력하세요');
      return;
    } else {
      setErrorMessage('');
    }
    return axios
      .post(process.env.REACT_APP_TEST_LOGIN_URL,{loginInfo, checkedKeepLogin})
      .then((res) => {
        // 로그인에 성공했다면 응답으로 받은 데이터가 Mypage에 렌더링되도록 State를 변경하세요.
        SignIn();
        console.log(res.data);
        setUserInfo(res.data);
        setIsLogin(true);
      })
      .catch((err) => {
        console.log(err.response.data);
        setErrorMessage('로그인에 실패했습니다.');
        // 로그인에 실패했다면 그에 대한 에러 핸들링을 구현하세요.
      });
  };

  return (
    <>
      <Header />
      <PaddingBox />
      <Background>
        <ContentsBox>
          <TitleZone>
            <font.H1>로그인</font.H1>
            <font.H4>호박공구마 서비스를 이용하기 위해 로그인해주세요.</font.H4>
          </TitleZone>
          <LoginInfoBox>
            <div>
              <font.H3>아이디</font.H3>
              <InputBox
                type="text"
                placeholder="이메일주소 입력"
                onChange={handleInputValue('userId')}
              ></InputBox>
            </div>
            <div>
              <font.H3>비밀번호</font.H3>
              <InputBox
                type="password"
                placeholder="비밀번호 입력"
                onChange={handleInputValue('password')}
              ></InputBox>
            </div>
            <CheckZone>
              <div>
                <input
                  type="checkbox"
                  onChange={() => setCheckedKeepLogin(!checkedKeepLogin)}
                />
                <font.P>아이디저장</font.P>
              </div>
              <div>
                <font.P>회원가입/</font.P>
                <font.P>비밀번호재설정</font.P>
              </div>
            </CheckZone>
          </LoginInfoBox>
          <ButtonZone>
            <LoginButton type="submit" onClick={loginRequestHandler}>
              로그인
            </LoginButton>
            {errorMessage ? (
              <div id="alert-message" data-testid="alert-message">
                {errorMessage}
              </div>
            ) : (
              ''
            )}
            <KaKaoLogin>카카오톡 로그인</KaKaoLogin>
          </ButtonZone>
        </ContentsBox>
      </Background>
      <Footer />
    </>
  );
}

export default LoginPage;
