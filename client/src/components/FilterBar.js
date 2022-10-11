import React from 'react';
import { useState } from 'react';
import { useEffect } from 'react';
import { Routes, Route, Link, useNavigate, Outlet } from 'react-router-dom';
import styled from 'styled-components';
import PostListPage from '../pages/PostListPage';

let FilterBox = styled.div`
  margin-top: 1%;
  width: 800px;
  height: 40px;
  border: 1px solid gray;
  border-radius: 10px;
  display: flex;
  justify-content: space-around;
  align-items: center;
`;
let Filters = styled.div`
  width: auto;
  height: auto;
  padding-left: 5px;
  padding-right: 5px;
  font-weight: 400;
  font-size: 13px;
  border-right: 1px solid gray;
  display: flex;
  justify-content: center;
  align-items: center;
  &:hover {
    color: #f0be29;
    cursor: pointer;
  }
`;
let All = styled(Filters)`
  font-weight: 600;
`;

function FilterBar() {
  //유즈파람스로 클릭한 번호 보내고 그 파람스에 맞춰 맵핑한다.
  let navigate = useNavigate();
  return (
    <FilterBox>
      <All
        onClick={() => {
          navigate('/');
        }}
      >
        전체보기
      </All>
      <Filters
        onClick={() => {
          navigate('/1');
        }}
      >
        1인분 주문{' '}
      </Filters>
      <Filters
        onClick={() => {
          navigate('/2');
        }}
      >
        프렌차이즈
      </Filters>
      <Filters
        onClick={() => {
          navigate('/3');
        }}
      >
        치킨
      </Filters>
      <Filters
        onClick={() => {
          navigate('/4');
        }}
      >
        피자/양식
      </Filters>
      <Filters
        onClick={() => {
          navigate('/5');
        }}
      >
        중국집
      </Filters>
      <Filters
        onClick={() => {
          navigate('/6');
        }}
      >
        한식
      </Filters>
      <Filters
        onClick={() => {
          navigate('/7');
        }}
      >
        일식/돈까스
      </Filters>
      <Filters
        onClick={() => {
          navigate('/8');
        }}
      >
        족발/보쌈
      </Filters>
      <Filters
        onClick={() => {
          navigate('/9');
        }}
      >
        야식
      </Filters>
      <Filters
        onClick={() => {
          navigate('/10');
        }}
      >
        분식
      </Filters>
      <Filters
        onClick={() => {
          navigate('/11');
        }}
      >
        까페/디저트
      </Filters>
      <Filters
        onClick={() => {
          navigate('/12');
        }}
      >
        편의점/마트
      </Filters>
    </FilterBox>
  );
}
export default FilterBar;
