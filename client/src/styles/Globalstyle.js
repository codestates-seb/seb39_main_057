import React from 'react';
import { createGlobalStyle } from 'styled-components';
import font from './font';
import reset from 'styled-reset';

const GlobalStyle = createGlobalStyle`
    ${reset};
    body{
        padding: 0;
        margin: 0;
        font-family: Pretendard, -apple-system, BlinkMacSystemFont, system-ui, Roboto, "Helvetica Neue", "Segoe UI", "Apple SD Gothic Neo", "Noto Sans KR", "Malgun Gothic", "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", sans-serif;
        letter-spacing: -0.5px;
        margin:0px;
        touch-action: pan-y; 
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
    };
    button{
        display: flex;
        cursor: pointer;
        outline: none;
        border-radius: 3px;
    };
    input{
        display: flex;
        outline: none;
        padding-left: 10px;
    }
`;

export default GlobalStyle;
