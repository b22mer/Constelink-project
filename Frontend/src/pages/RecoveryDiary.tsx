import React, { useState } from 'react';
import searchIcon from  "../assets/logo/search_icon.png";
import styles from './RecoveryDiary.module.css';
import profileImg1 from "../assets/img/profile1.png";
import profileImg2 from "../assets/img/profile2.png";
import profileImg3 from "../assets/img/profile3.png";
// import Header from 'components/header/Header';
// header 코드 따로 빼서 넣어줘야 함
// 카드 배열
const cards = [
  {
    title: "치료일지 1",
    image: profileImg1,
    content: ["췌장암", "허리골절", "습진","췌장암", "허리골절", "습진","췌장암", "허리골절", "습진"],
    hospital: "서울대병원"
  },
  {
    title: "치료일지 2",
    image: profileImg2,
    content: ["대장암"],
    hospital: "길병원"
  },
  {
    title: "치료일지 4",
    image: profileImg3,
    content: ["골절"],
    hospital: "을지대병원"
  },
  {
    title: "치료일지 5",
    image: profileImg1,
    content: ["골절"],
    hospital: "세브란스병원"
  },
  {
    title: "치료일지 6",
    image: profileImg2,
    content: ["위궤양"],
    hospital: "길병원"
  },
  {
    title: "치료일지 7",
    image: profileImg3,
    content: ["간암"],
    hospital: "세브란스병원"
  },
];

const RecoveryDiary : React.FC = ()=>{
  const [searchKeyword, setSearchKeyword] = useState('');

  // Card title에 검색어가 있는지 여부를 확인
  const filteredCards = searchKeyword ? 
    // cards.filter((card) => card.title.includes(searchKeyword)) :
    // cards;
    // cards.filter((card) => card.content.includes(searchKeyword)) :
    // cards;
    // cards.filter((card) => card.hospital.includes(searchKeyword)) :
    // cards;

    cards.filter((card) => {
      const isInTitle = card.title.includes(searchKeyword);
      const isInContent = card.content.some((item) => item.includes(searchKeyword));
      const isInHospital = card.hospital.includes(searchKeyword);
      return isInTitle || isInContent || isInHospital;
    }) :
    cards;
  
  return (
    <div>
      <div className={styles.container}>
        <div className={styles.item}>
          <div className={styles.searchContainer}> 
              <p className={styles.searchBarText}>치료일지</p>
            <div className={styles.searchInputContainer}>
              <img src={searchIcon} alt="search" className={styles.searchIcon} />
              <input 
                type="text" 
                placeholder="병원 혹은 병명을 검색하세요" 
                className={styles.searchInput}
                value={searchKeyword} 
                onChange={(e) => setSearchKeyword(e.target.value)} 
                />
            </div>
          </div>
          <div className={styles.garoseon}>
            <hr/>
          </div>
          <div className={styles.searchResult}>
          <div>{"\""}</div>
            {searchKeyword && (
            <div className={styles.searchResultMain}>
            {searchKeyword}
            </div>
            )}
          <div>{"\""}</div>
          (으)로 검색한 조회결과입니다.
          </div>

          {/* 검색어에 입력한대로 반응형 결과 도출 */}
          {filteredCards.map((card, index) => (
            <div className={styles.card} key={index}>
              <div className={styles.cardTop}>
              </div>
              <div className={styles.imageContainer}>
                <img src={card.image} alt="profile" className={styles.image} />
              </div>
              <div className={styles.titleContent}>
                <p className={styles.title}>{card.title}</p>
                <div className={styles.content}>
                  {card.content.map((item, index) => (
                    <div className={styles.contentItem} key={index}>
                      {item}
                    </div>
                  ))}
                </div>
              </div>
              {/* 더 알아보기 버튼(디테일페이지로 이동) */}
              <div className={styles.bottomContent}>
                <div className={styles.detailButton}>더 알아보기</div>
              </div>
              </div>
          ))}
        </div>
      </div>
    </div>
  );
};

export default RecoveryDiary;

