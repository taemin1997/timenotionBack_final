<<<<<<< HEAD
SELECT *
FROM GGHJ_BOARD G
JOIN GGHJ_USER U ON G.USER_ID = U.USER_ID
WHERE G.BOARD_ID = #{boardId};
       
            SELECT
            u.USER_NICKNAME, b.BOARD_TITLE
        FROM
            GGHJ_BOARD b JOIN GGHJ_USER u
                              ON u.user_id = b.USER_ID
        ORDER BY
            b.BOARD_LIKE_COUNT DESC;
            
             SELECT *
    FROM GGHJ_BOARD G
    JOIN GGHJ_UNI U ON G.USER_ID = U.UNI_ID
    WHERE G.USER_ID = #{userId}
    
    -- user 테이블 더미
INSERT INTO GGHJ_USER (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_NICKNAME, USER_BIRTH) 
VALUES (6, 'John Doe', 'password123', 'johndoe@example.com', 'johnny', TO_DATE('1990-01-01', 'YYYY-MM-DD'));

INSERT INTO GGHJ_USER (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_NICKNAME, USER_BIRTH) 
VALUES (7, 'Jane Smith', 'password456', 'janesmith@example.com', 'jane_s', TO_DATE('1985-05-15', 'YYYY-MM-DD'));

INSERT INTO GGHJ_USER (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_NICKNAME, USER_BIRTH) 
VALUES (8, 'Alice Johnson', 'password789', 'alicej@example.com', 'alicej', TO_DATE('1992-03-22', 'YYYY-MM-DD'));

INSERT INTO GGHJ_USER (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_NICKNAME, USER_BIRTH) 
VALUES (9, 'Bob Brown', 'password321', 'bobbrown@example.com', 'bobbyb', TO_DATE('1988-11-11', 'YYYY-MM-DD'));

INSERT INTO GGHJ_USER (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_NICKNAME, USER_BIRTH) 
VALUES (10, 'Charlie Davis', 'password654', 'charliedavis@example.com', 'charlied', TO_DATE('1995-07-07', 'YYYY-MM-DD'));

SELECT * FROM gghj_user;

INSERT INTO GGHJ_BOARD (
    BOARD_ID,
    BOARD_TITLE,
    BOARD_CONTENT,
    BOARD_PUBLIC,
    BOARD_CREATED_DATE,
    BOARD_UPDATED_DATE,
    BOARD_VIEW_COUNT,
    BOARD_LIFE_CYCLE,
    BOARD_LIKE_COUNT,
    BOARD_YEAR,
    USER_ID
) VALUES (
    6,
    '게시물 6 제목',
    '게시물 6 내용입니다.',
    'O',
    SYSDATE,
    SYSDATE,
    10,
    '청소년기',
    5,
    '2024',
    6
);

-- 두 번째 더미 데이터
INSERT INTO GGHJ_BOARD (
    BOARD_ID,
    BOARD_TITLE,
    BOARD_CONTENT,
    BOARD_PUBLIC,
    BOARD_CREATED_DATE,
    BOARD_UPDATED_DATE,
    BOARD_VIEW_COUNT,
    BOARD_LIFE_CYCLE,
    BOARD_LIKE_COUNT,
    BOARD_YEAR,
    USER_ID
) VALUES (
    7,
    '게시물 7 제목',
    '게시물 7 내용입니다.',
    'O',
    SYSDATE,
    SYSDATE,
    20,
    '청소년기',
    10,
    '2024',
    7
);

-- 세 번째 더미 데이터
INSERT INTO GGHJ_BOARD (
    BOARD_ID,
    BOARD_TITLE,
    BOARD_CONTENT,
    BOARD_PUBLIC,
    BOARD_CREATED_DATE,
    BOARD_UPDATED_DATE,
    BOARD_VIEW_COUNT,
    BOARD_LIFE_CYCLE,
    BOARD_LIKE_COUNT,
    BOARD_YEAR,
    USER_ID
) VALUES (
    8,
    '게시물 8 제목',
    '게시물 8 내용입니다.',
    'O',
    SYSDATE,
    SYSDATE,
    30,
    '청소년기',
    15,
    '2024',
    8
);

-- 네 번째 더미 데이터
INSERT INTO GGHJ_BOARD (
    BOARD_ID,
    BOARD_TITLE,
    BOARD_CONTENT,
    BOARD_PUBLIC,
    BOARD_CREATED_DATE,
    BOARD_UPDATED_DATE,
    BOARD_VIEW_COUNT,
    BOARD_LIFE_CYCLE,
    BOARD_LIKE_COUNT,
    BOARD_YEAR,
    USER_ID
) VALUES (
    9,
    '게시물 9 제목',
    '게시물 9 내용입니다.',
    'O',
    SYSDATE,
    SYSDATE,
    40,
    '청소년기',
    20,
    '2024',
    9
);

-- 다섯 번째 더미 데이터
INSERT INTO GGHJ_BOARD (
    BOARD_ID,
    BOARD_TITLE,
    BOARD_CONTENT,
    BOARD_PUBLIC,
    BOARD_CREATED_DATE,
    BOARD_UPDATED_DATE,
    BOARD_VIEW_COUNT,
    BOARD_LIFE_CYCLE,
    BOARD_LIKE_COUNT,
    BOARD_YEAR,
    USER_ID
) VALUES (
    10,
    '게시물 10 제목',
    '게시물 10 내용입니다.',
    'O',
    SYSDATE,
    SYSDATE,
    50,
    '청소년기',
    25,
    '2024',
    10
);

INSERT INTO GGHJ_BOARD (
    BOARD_ID,
    BOARD_TITLE,
    BOARD_CONTENT,
    BOARD_PUBLIC,
    BOARD_CREATED_DATE,
    BOARD_UPDATED_DATE,
    BOARD_VIEW_COUNT,
    BOARD_LIFE_CYCLE,
    BOARD_LIKE_COUNT,
    BOARD_YEAR,
    USER_ID
) VALUES (
    12,
    '게시물 12 제목',
    '게시물 12 내용입니다.',
    'O',
    SYSDATE,
    SYSDATE,
    50,
    '노년기',
    25,
    '2024',
    12
);









INSERT INTO GGHJ_USER (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_NICKNAME, USER_BIRTH) 
VALUES (11, 'David Lee', 'password111', 'davidlee@example.com', 'davidl', TO_DATE('1987-09-03', 'YYYY-MM-DD'));

INSERT INTO GGHJ_USER (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_NICKNAME, USER_BIRTH) 
VALUES (12, 'Emma Martinez', 'password222', 'emmam@example.com', 'emmam', TO_DATE('1994-11-25', 'YYYY-MM-DD'));

INSERT INTO GGHJ_USER (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_NICKNAME, USER_BIRTH) 
VALUES (13, 'Olivia Garcia', 'password333', 'oliviag@example.com', 'oliviag', TO_DATE('1983-07-18', 'YYYY-MM-DD'));

INSERT INTO GGHJ_USER (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_NICKNAME, USER_BIRTH) 
VALUES (14, 'Michael Hernandez', 'password444', 'michaelh@example.com', 'michaelh', TO_DATE('1990-02-10', 'YYYY-MM-DD'));

INSERT INTO GGHJ_USER (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_NICKNAME, USER_BIRTH) 
VALUES (15, 'Sophia Lopez', 'password555', 'sophial@example.com', 'sophial', TO_DATE('1986-12-30', 'YYYY-MM-DD'));

INSERT INTO GGHJ_USER (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_NICKNAME, USER_BIRTH) 
VALUES (16, 'Daniel Gonzalez', 'password666', 'danielg@example.com', 'danielg', TO_DATE('1993-05-05', 'YYYY-MM-DD'));

INSERT INTO GGHJ_USER (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_NICKNAME, USER_BIRTH) 
VALUES (17, 'Isabella Wilson', 'password777', 'isabellaw@example.com', 'isabellaw', TO_DATE('1989-08-15', 'YYYY-MM-DD'));

INSERT INTO GGHJ_USER (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_NICKNAME, USER_BIRTH) 
VALUES (18, 'Matthew Taylor', 'password888', 'matthewt@example.com', 'matthewt', TO_DATE('1991-04-20', 'YYYY-MM-DD'));

INSERT INTO GGHJ_USER (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_NICKNAME, USER_BIRTH) 
VALUES (19, 'Emily Anderson', 'password999', 'emilya@example.com', 'emilya', TO_DATE('1984-10-12', 'YYYY-MM-DD'));

INSERT INTO GGHJ_USER (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_NICKNAME, USER_BIRTH) 
VALUES (20, 'Ethan Thomas', 'password000', 'ethant@example.com', 'ethant', TO_DATE('1996-08-22', 'YYYY-MM-DD'));

-- 11번 게시물 추가
INSERT INTO GGHJ_BOARD (
    BOARD_ID,
    BOARD_TITLE,
    BOARD_CONTENT,
    BOARD_PUBLIC,
    BOARD_CREATED_DATE,
    BOARD_UPDATED_DATE,
    BOARD_VIEW_COUNT,
    BOARD_LIFE_CYCLE,
    BOARD_LIKE_COUNT,
    BOARD_YEAR,
    USER_ID
) VALUES (
    11,
    '게시물 11 제목',
    '게시물 11 내용입니다.',
    'O',
    SYSDATE,
    SYSDATE,
    60,
    '청소년기',
    30,
    '2024',
    11
);



SELECT * FROM gghj_user;
SELECT * FROM GGHJ_BOARD;
SELECT * FROM GGHJ_UNI;


-- 12번 게시물 추가
INSERT INTO GGHJ_BOARD (
    BOARD_ID,
    BOARD_TITLE,
    BOARD_CONTENT,
    BOARD_PUBLIC,
    BOARD_CREATED_DATE,
    BOARD_UPDATED_DATE,
    BOARD_VIEW_COUNT,
    BOARD_LIFE_CYCLE,
    BOARD_LIKE_COUNT,
    BOARD_YEAR,
    USER_ID
) VALUES (
    12,
    '게시물 12 제목',
    '게시물 12 내용입니다.',
    'O',
    SYSDATE,
    SYSDATE,
    70,
    '청년기',
    35,
    '2024',
    12
);

-- 13번 게시물 추가
INSERT INTO GGHJ_BOARD (
    BOARD_ID,
    BOARD_TITLE,
    BOARD_CONTENT,
    BOARD_PUBLIC,
    BOARD_CREATED_DATE,
    BOARD_UPDATED_DATE,
    BOARD_VIEW_COUNT,
    BOARD_LIFE_CYCLE,
    BOARD_LIKE_COUNT,
    BOARD_YEAR,
    USER_ID
) VALUES (
    13,
    '게시물 13 제목',
    '게시물 13 내용입니다.',
    'O',
    SYSDATE,
    SYSDATE,
    80,
    '청년기',
    40,
    '2024',
    13
);

-- 14번 게시물 추가
INSERT INTO GGHJ_BOARD (
    BOARD_ID,
    BOARD_TITLE,
    BOARD_CONTENT,
    BOARD_PUBLIC,
    BOARD_CREATED_DATE,
    BOARD_UPDATED_DATE,
    BOARD_VIEW_COUNT,
    BOARD_LIFE_CYCLE,
    BOARD_LIKE_COUNT,
    BOARD_YEAR,
    USER_ID
) VALUES (
    14,
    '게시물 14 제목',
    '게시물 14 내용입니다.',
    'O',
    SYSDATE,
    SYSDATE,
    90,
    '청소년기',
    45,
    '2024',
    14
);

-- 15번 게시물 추가
INSERT INTO GGHJ_BOARD (
    BOARD_ID,
    BOARD_TITLE,
    BOARD_CONTENT,
    BOARD_PUBLIC,
    BOARD_CREATED_DATE,
    BOARD_UPDATED_DATE,
    BOARD_VIEW_COUNT,
    BOARD_LIFE_CYCLE,
    BOARD_LIKE_COUNT,
    BOARD_YEAR,
    USER_ID
) VALUES (
    15,
    '게시물 15 제목',
    '게시물 15 내용입니다.',
    'O',
    SYSDATE,
    SYSDATE,
    100,
    '청소년기',
    50,
    '2024',
    15
);

-- 16번 게시물 추가
INSERT INTO GGHJ_BOARD (
    BOARD_ID,
    BOARD_TITLE,
    BOARD_CONTENT,
    BOARD_PUBLIC,
    BOARD_CREATED_DATE,
    BOARD_UPDATED_DATE,
    BOARD_VIEW_COUNT,
    BOARD_LIFE_CYCLE,
    BOARD_LIKE_COUNT,
    BOARD_YEAR,
    USER_ID
) VALUES (
    16,
    '게시물 16 제목',
    '게시물 16 내용입니다.',
    'O',
    SYSDATE,
    SYSDATE,
    110,
    '청소년기',
    55,
    '2024',
    16
);

-- 17번 게시물 추가
INSERT INTO GGHJ_BOARD (
    BOARD_ID,
    BOARD_TITLE,
    BOARD_CONTENT,
    BOARD_PUBLIC,
    BOARD_CREATED_DATE,
    BOARD_UPDATED_DATE,
    BOARD_VIEW_COUNT,
    BOARD_LIFE_CYCLE,
    BOARD_LIKE_COUNT,
    BOARD_YEAR,
    USER_ID
) VALUES (
    17,
    '게시물 17 제목',
    '게시물 17 내용입니다.',
    'O',
    SYSDATE,
    SYSDATE,
    120,
    '청소년기',
    60,
    '2024',
    17
);

-- 18번 게시물 추가
INSERT INTO GGHJ_BOARD (
    BOARD_ID,
    BOARD_TITLE,
    BOARD_CONTENT,
    BOARD_PUBLIC,
    BOARD_CREATED_DATE,
    BOARD_UPDATED_DATE,
    BOARD_VIEW_COUNT,
    BOARD_LIFE_CYCLE,
    BOARD_LIKE_COUNT,
    BOARD_YEAR,
    USER_ID
) VALUES (
    18,
    '게시물 18 제목',
    '게시물 18 내용입니다.',
    'O',
    SYSDATE,
    SYSDATE,
    130,
    '청소년기',
    65,
    '2024',
    18
);

-- 19번 게시물 추가
INSERT INTO GGHJ_BOARD (
    BOARD_ID,
    BOARD_TITLE,
    BOARD_CONTENT,
    BOARD_PUBLIC,
    BOARD_CREATED_DATE,
    BOARD_UPDATED_DATE,
    BOARD_VIEW_COUNT,
    BOARD_LIFE_CYCLE,
    BOARD_LIKE_COUNT,
    BOARD_YEAR,
    USER_ID
) VALUES (
    19,
    '게시물 19 제목',
    '게시물 19 내용입니다.',
    'O',
    SYSDATE,
    SYSDATE,
    140,
    '청소년기',
    70,
    '2024',
    19
);

-- 20번 게시물 추가
INSERT INTO GGHJ_BOARD (
    BOARD_ID,
    BOARD_TITLE,
    BOARD_CONTENT,
    BOARD_PUBLIC,
    BOARD_CREATED_DATE,
    BOARD_UPDATED_DATE,
    BOARD_VIEW_COUNT,
    BOARD_LIFE_CYCLE,
    BOARD_LIKE_COUNT,
    BOARD_YEAR,
    USER_ID
) VALUES (
    20,
    '게시물 20 제목',
    '게시물 20 내용입니다.',
    'O',
    SYSDATE,
    SYSDATE,
    150,
    '청소년기',
    75,
    '2024',
    20
);

-- GGHJ_UNI 테이블의 더미 데이터
    INSERT INTO GGHJ_UNI (UNI_ID, UNI_STATUS, UNI_ABOUT, USER_ID, KAKAO_ID)
    VALUES (11, '일반', 'Standard user profile', 11, 11);

    INSERT INTO GGHJ_UNI (UNI_ID, UNI_STATUS, UNI_ABOUT, USER_ID, KAKAO_ID)
    VALUES (12, '일반', 'User profile suspended', 12, 12);

    INSERT INTO GGHJ_UNI (UNI_ID, UNI_STATUS, UNI_ABOUT, USER_ID, KAKAO_ID)
    VALUES (13, '일반', 'User profile withdrawn', 13, 13);

    INSERT INTO GGHJ_UNI (UNI_ID, UNI_STATUS, UNI_ABOUT, USER_ID, KAKAO_ID)
    VALUES (14, '일반', 'Active user profile', 14, 14);

    INSERT INTO GGHJ_UNI (UNI_ID, UNI_STATUS, UNI_ABOUT, USER_ID, KAKAO_ID)
    VALUES (15, '일반', 'Inactive user profile', 15, 15);
   
    INSERT INTO GGHJ_UNI (UNI_ID, UNI_STATUS, UNI_ABOUT, USER_ID, KAKAO_ID)
    VALUES (16, '일반', 'Standard user profile', 16, 16);

    INSERT INTO GGHJ_UNI (UNI_ID, UNI_STATUS, UNI_ABOUT, USER_ID, KAKAO_ID)
    VALUES (17, '일반', 'User profile suspended', 17, 17);

    INSERT INTO GGHJ_UNI (UNI_ID, UNI_STATUS, UNI_ABOUT, USER_ID, KAKAO_ID)
    VALUES (18, '일반', 'User profile withdrawn', 18, 18);

    INSERT INTO GGHJ_UNI (UNI_ID, UNI_STATUS, UNI_ABOUT, USER_ID, KAKAO_ID)
    VALUES (19, '일반', 'Active user profile', 19, 19);

    INSERT INTO GGHJ_UNI (UNI_ID, UNI_STATUS, UNI_ABOUT, USER_ID, KAKAO_ID)
    VALUES (20, '일반', 'Inactive user profile', 20, 20);
   
    SELECT * FROM GGHJ_UNI;
   
    SELECT
            *
        FROM
            GGHJ_BOARD b JOIN GGHJ_USER u
                              ON u.user_id = b.USER_ID
        ORDER BY
            b.BOARD_LIKE_COUNT DESC;
           
           SELECT * FROM gghj_kakao;






    
    
    
    
    
    
    
=======
SELECT *
FROM GGHJ_BOARD G
JOIN GGHJ_USER U ON G.USER_ID = U.USER_ID
WHERE G.BOARD_ID = #{boardId};
       
            SELECT
            u.USER_NICKNAME, b.BOARD_TITLE
        FROM
            GGHJ_BOARD b JOIN GGHJ_USER u
                              ON u.user_id = b.USER_ID
        ORDER BY
            b.BOARD_LIKE_COUNT DESC;
            
             SELECT *
    FROM GGHJ_BOARD G
    JOIN GGHJ_UNI U ON G.USER_ID = U.UNI_ID
    WHERE G.USER_ID = #{userId}
    
    -- user 테이블 더미
INSERT INTO GGHJ_USER (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_NICKNAME, USER_BIRTH) 
VALUES (6, 'John Doe', 'password123', 'johndoe@example.com', 'johnny', TO_DATE('1990-01-01', 'YYYY-MM-DD'));

INSERT INTO GGHJ_USER (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_NICKNAME, USER_BIRTH) 
VALUES (7, 'Jane Smith', 'password456', 'janesmith@example.com', 'jane_s', TO_DATE('1985-05-15', 'YYYY-MM-DD'));

INSERT INTO GGHJ_USER (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_NICKNAME, USER_BIRTH) 
VALUES (8, 'Alice Johnson', 'password789', 'alicej@example.com', 'alicej', TO_DATE('1992-03-22', 'YYYY-MM-DD'));

INSERT INTO GGHJ_USER (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_NICKNAME, USER_BIRTH) 
VALUES (9, 'Bob Brown', 'password321', 'bobbrown@example.com', 'bobbyb', TO_DATE('1988-11-11', 'YYYY-MM-DD'));

INSERT INTO GGHJ_USER (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_NICKNAME, USER_BIRTH) 
VALUES (10, 'Charlie Davis', 'password654', 'charliedavis@example.com', 'charlied', TO_DATE('1995-07-07', 'YYYY-MM-DD'));

SELECT * FROM gghj_user;

INSERT INTO GGHJ_BOARD (
    BOARD_ID,
    BOARD_TITLE,
    BOARD_CONTENT,
    BOARD_PUBLIC,
    BOARD_CREATED_DATE,
    BOARD_UPDATED_DATE,
    BOARD_VIEW_COUNT,
    BOARD_LIFE_CYCLE,
    BOARD_LIKE_COUNT,
    BOARD_YEAR,
    USER_ID
) VALUES (
    6,
    '게시물 6 제목',
    '게시물 6 내용입니다.',
    'O',
    SYSDATE,
    SYSDATE,
    10,
    '청소년기',
    5,
    '2024',
    6
);

-- 두 번째 더미 데이터
INSERT INTO GGHJ_BOARD (
    BOARD_ID,
    BOARD_TITLE,
    BOARD_CONTENT,
    BOARD_PUBLIC,
    BOARD_CREATED_DATE,
    BOARD_UPDATED_DATE,
    BOARD_VIEW_COUNT,
    BOARD_LIFE_CYCLE,
    BOARD_LIKE_COUNT,
    BOARD_YEAR,
    USER_ID
) VALUES (
    7,
    '게시물 7 제목',
    '게시물 7 내용입니다.',
    'O',
    SYSDATE,
    SYSDATE,
    20,
    '청소년기',
    10,
    '2024',
    7
);

-- 세 번째 더미 데이터
INSERT INTO GGHJ_BOARD (
    BOARD_ID,
    BOARD_TITLE,
    BOARD_CONTENT,
    BOARD_PUBLIC,
    BOARD_CREATED_DATE,
    BOARD_UPDATED_DATE,
    BOARD_VIEW_COUNT,
    BOARD_LIFE_CYCLE,
    BOARD_LIKE_COUNT,
    BOARD_YEAR,
    USER_ID
) VALUES (
    8,
    '게시물 8 제목',
    '게시물 8 내용입니다.',
    'O',
    SYSDATE,
    SYSDATE,
    30,
    '청소년기',
    15,
    '2024',
    8
);

-- 네 번째 더미 데이터
INSERT INTO GGHJ_BOARD (
    BOARD_ID,
    BOARD_TITLE,
    BOARD_CONTENT,
    BOARD_PUBLIC,
    BOARD_CREATED_DATE,
    BOARD_UPDATED_DATE,
    BOARD_VIEW_COUNT,
    BOARD_LIFE_CYCLE,
    BOARD_LIKE_COUNT,
    BOARD_YEAR,
    USER_ID
) VALUES (
    9,
    '게시물 9 제목',
    '게시물 9 내용입니다.',
    'O',
    SYSDATE,
    SYSDATE,
    40,
    '청소년기',
    20,
    '2024',
    9
);

-- 다섯 번째 더미 데이터
INSERT INTO GGHJ_BOARD (
    BOARD_ID,
    BOARD_TITLE,
    BOARD_CONTENT,
    BOARD_PUBLIC,
    BOARD_CREATED_DATE,
    BOARD_UPDATED_DATE,
    BOARD_VIEW_COUNT,
    BOARD_LIFE_CYCLE,
    BOARD_LIKE_COUNT,
    BOARD_YEAR,
    USER_ID
) VALUES (
    10,
    '게시물 10 제목',
    '게시물 10 내용입니다.',
    'O',
    SYSDATE,
    SYSDATE,
    50,
    '청소년기',
    25,
    '2024',
    10
);

INSERT INTO GGHJ_BOARD (
    BOARD_ID,
    BOARD_TITLE,
    BOARD_CONTENT,
    BOARD_PUBLIC,
    BOARD_CREATED_DATE,
    BOARD_UPDATED_DATE,
    BOARD_VIEW_COUNT,
    BOARD_LIFE_CYCLE,
    BOARD_LIKE_COUNT,
    BOARD_YEAR,
    USER_ID
) VALUES (
    12,
    '게시물 12 제목',
    '게시물 12 내용입니다.',
    'O',
    SYSDATE,
    SYSDATE,
    50,
    '노년기',
    25,
    '2024',
    12
);









INSERT INTO GGHJ_USER (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_NICKNAME, USER_BIRTH) 
VALUES (11, 'David Lee', 'password111', 'davidlee@example.com', 'davidl', TO_DATE('1987-09-03', 'YYYY-MM-DD'));

INSERT INTO GGHJ_USER (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_NICKNAME, USER_BIRTH) 
VALUES (12, 'Emma Martinez', 'password222', 'emmam@example.com', 'emmam', TO_DATE('1994-11-25', 'YYYY-MM-DD'));

INSERT INTO GGHJ_USER (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_NICKNAME, USER_BIRTH) 
VALUES (13, 'Olivia Garcia', 'password333', 'oliviag@example.com', 'oliviag', TO_DATE('1983-07-18', 'YYYY-MM-DD'));

INSERT INTO GGHJ_USER (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_NICKNAME, USER_BIRTH) 
VALUES (14, 'Michael Hernandez', 'password444', 'michaelh@example.com', 'michaelh', TO_DATE('1990-02-10', 'YYYY-MM-DD'));

INSERT INTO GGHJ_USER (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_NICKNAME, USER_BIRTH) 
VALUES (15, 'Sophia Lopez', 'password555', 'sophial@example.com', 'sophial', TO_DATE('1986-12-30', 'YYYY-MM-DD'));

INSERT INTO GGHJ_USER (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_NICKNAME, USER_BIRTH) 
VALUES (16, 'Daniel Gonzalez', 'password666', 'danielg@example.com', 'danielg', TO_DATE('1993-05-05', 'YYYY-MM-DD'));

INSERT INTO GGHJ_USER (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_NICKNAME, USER_BIRTH) 
VALUES (17, 'Isabella Wilson', 'password777', 'isabellaw@example.com', 'isabellaw', TO_DATE('1989-08-15', 'YYYY-MM-DD'));

INSERT INTO GGHJ_USER (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_NICKNAME, USER_BIRTH) 
VALUES (18, 'Matthew Taylor', 'password888', 'matthewt@example.com', 'matthewt', TO_DATE('1991-04-20', 'YYYY-MM-DD'));

INSERT INTO GGHJ_USER (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_NICKNAME, USER_BIRTH) 
VALUES (19, 'Emily Anderson', 'password999', 'emilya@example.com', 'emilya', TO_DATE('1984-10-12', 'YYYY-MM-DD'));

INSERT INTO GGHJ_USER (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_NICKNAME, USER_BIRTH) 
VALUES (20, 'Ethan Thomas', 'password000', 'ethant@example.com', 'ethant', TO_DATE('1996-08-22', 'YYYY-MM-DD'));

-- 11번 게시물 추가
INSERT INTO GGHJ_BOARD (
    BOARD_ID,
    BOARD_TITLE,
    BOARD_CONTENT,
    BOARD_PUBLIC,
    BOARD_CREATED_DATE,
    BOARD_UPDATED_DATE,
    BOARD_VIEW_COUNT,
    BOARD_LIFE_CYCLE,
    BOARD_LIKE_COUNT,
    BOARD_YEAR,
    USER_ID
) VALUES (
    11,
    '게시물 11 제목',
    '게시물 11 내용입니다.',
    'O',
    SYSDATE,
    SYSDATE,
    60,
    '청소년기',
    30,
    '2024',
    11
);



SELECT * FROM gghj_user;
SELECT * FROM GGHJ_BOARD;
SELECT * FROM GGHJ_UNI;


-- 12번 게시물 추가
INSERT INTO GGHJ_BOARD (
    BOARD_ID,
    BOARD_TITLE,
    BOARD_CONTENT,
    BOARD_PUBLIC,
    BOARD_CREATED_DATE,
    BOARD_UPDATED_DATE,
    BOARD_VIEW_COUNT,
    BOARD_LIFE_CYCLE,
    BOARD_LIKE_COUNT,
    BOARD_YEAR,
    USER_ID
) VALUES (
    12,
    '게시물 12 제목',
    '게시물 12 내용입니다.',
    'O',
    SYSDATE,
    SYSDATE,
    70,
    '청년기',
    35,
    '2024',
    12
);

-- 13번 게시물 추가
INSERT INTO GGHJ_BOARD (
    BOARD_ID,
    BOARD_TITLE,
    BOARD_CONTENT,
    BOARD_PUBLIC,
    BOARD_CREATED_DATE,
    BOARD_UPDATED_DATE,
    BOARD_VIEW_COUNT,
    BOARD_LIFE_CYCLE,
    BOARD_LIKE_COUNT,
    BOARD_YEAR,
    USER_ID
) VALUES (
    13,
    '게시물 13 제목',
    '게시물 13 내용입니다.',
    'O',
    SYSDATE,
    SYSDATE,
    80,
    '청년기',
    40,
    '2024',
    13
);

-- 14번 게시물 추가
INSERT INTO GGHJ_BOARD (
    BOARD_ID,
    BOARD_TITLE,
    BOARD_CONTENT,
    BOARD_PUBLIC,
    BOARD_CREATED_DATE,
    BOARD_UPDATED_DATE,
    BOARD_VIEW_COUNT,
    BOARD_LIFE_CYCLE,
    BOARD_LIKE_COUNT,
    BOARD_YEAR,
    USER_ID
) VALUES (
    14,
    '게시물 14 제목',
    '게시물 14 내용입니다.',
    'O',
    SYSDATE,
    SYSDATE,
    90,
    '청소년기',
    45,
    '2024',
    14
);

-- 15번 게시물 추가
INSERT INTO GGHJ_BOARD (
    BOARD_ID,
    BOARD_TITLE,
    BOARD_CONTENT,
    BOARD_PUBLIC,
    BOARD_CREATED_DATE,
    BOARD_UPDATED_DATE,
    BOARD_VIEW_COUNT,
    BOARD_LIFE_CYCLE,
    BOARD_LIKE_COUNT,
    BOARD_YEAR,
    USER_ID
) VALUES (
    15,
    '게시물 15 제목',
    '게시물 15 내용입니다.',
    'O',
    SYSDATE,
    SYSDATE,
    100,
    '청소년기',
    50,
    '2024',
    15
);

-- 16번 게시물 추가
INSERT INTO GGHJ_BOARD (
    BOARD_ID,
    BOARD_TITLE,
    BOARD_CONTENT,
    BOARD_PUBLIC,
    BOARD_CREATED_DATE,
    BOARD_UPDATED_DATE,
    BOARD_VIEW_COUNT,
    BOARD_LIFE_CYCLE,
    BOARD_LIKE_COUNT,
    BOARD_YEAR,
    USER_ID
) VALUES (
    16,
    '게시물 16 제목',
    '게시물 16 내용입니다.',
    'O',
    SYSDATE,
    SYSDATE,
    110,
    '청소년기',
    55,
    '2024',
    16
);

-- 17번 게시물 추가
INSERT INTO GGHJ_BOARD (
    BOARD_ID,
    BOARD_TITLE,
    BOARD_CONTENT,
    BOARD_PUBLIC,
    BOARD_CREATED_DATE,
    BOARD_UPDATED_DATE,
    BOARD_VIEW_COUNT,
    BOARD_LIFE_CYCLE,
    BOARD_LIKE_COUNT,
    BOARD_YEAR,
    USER_ID
) VALUES (
    17,
    '게시물 17 제목',
    '게시물 17 내용입니다.',
    'O',
    SYSDATE,
    SYSDATE,
    120,
    '청소년기',
    60,
    '2024',
    17
);

-- 18번 게시물 추가
INSERT INTO GGHJ_BOARD (
    BOARD_ID,
    BOARD_TITLE,
    BOARD_CONTENT,
    BOARD_PUBLIC,
    BOARD_CREATED_DATE,
    BOARD_UPDATED_DATE,
    BOARD_VIEW_COUNT,
    BOARD_LIFE_CYCLE,
    BOARD_LIKE_COUNT,
    BOARD_YEAR,
    USER_ID
) VALUES (
    18,
    '게시물 18 제목',
    '게시물 18 내용입니다.',
    'O',
    SYSDATE,
    SYSDATE,
    130,
    '청소년기',
    65,
    '2024',
    18
);

-- 19번 게시물 추가
INSERT INTO GGHJ_BOARD (
    BOARD_ID,
    BOARD_TITLE,
    BOARD_CONTENT,
    BOARD_PUBLIC,
    BOARD_CREATED_DATE,
    BOARD_UPDATED_DATE,
    BOARD_VIEW_COUNT,
    BOARD_LIFE_CYCLE,
    BOARD_LIKE_COUNT,
    BOARD_YEAR,
    USER_ID
) VALUES (
    19,
    '게시물 19 제목',
    '게시물 19 내용입니다.',
    'O',
    SYSDATE,
    SYSDATE,
    140,
    '청소년기',
    70,
    '2024',
    19
);

-- 20번 게시물 추가
INSERT INTO GGHJ_BOARD (
    BOARD_ID,
    BOARD_TITLE,
    BOARD_CONTENT,
    BOARD_PUBLIC,
    BOARD_CREATED_DATE,
    BOARD_UPDATED_DATE,
    BOARD_VIEW_COUNT,
    BOARD_LIFE_CYCLE,
    BOARD_LIKE_COUNT,
    BOARD_YEAR,
    USER_ID
) VALUES (
    20,
    '게시물 20 제목',
    '게시물 20 내용입니다.',
    'O',
    SYSDATE,
    SYSDATE,
    150,
    '청소년기',
    75,
    '2024',
    20
);

-- GGHJ_UNI 테이블의 더미 데이터
    INSERT INTO GGHJ_UNI (UNI_ID, UNI_STATUS, UNI_ABOUT, USER_ID, KAKAO_ID)
    VALUES (11, '일반', 'Standard user profile', 11, 11);

    INSERT INTO GGHJ_UNI (UNI_ID, UNI_STATUS, UNI_ABOUT, USER_ID, KAKAO_ID)
    VALUES (12, '일반', 'User profile suspended', 12, 12);

    INSERT INTO GGHJ_UNI (UNI_ID, UNI_STATUS, UNI_ABOUT, USER_ID, KAKAO_ID)
    VALUES (13, '일반', 'User profile withdrawn', 13, 13);

    INSERT INTO GGHJ_UNI (UNI_ID, UNI_STATUS, UNI_ABOUT, USER_ID, KAKAO_ID)
    VALUES (14, '일반', 'Active user profile', 14, 14);

    INSERT INTO GGHJ_UNI (UNI_ID, UNI_STATUS, UNI_ABOUT, USER_ID, KAKAO_ID)
    VALUES (15, '일반', 'Inactive user profile', 15, 15);
   
    INSERT INTO GGHJ_UNI (UNI_ID, UNI_STATUS, UNI_ABOUT, USER_ID, KAKAO_ID)
    VALUES (16, '일반', 'Standard user profile', 16, 16);

    INSERT INTO GGHJ_UNI (UNI_ID, UNI_STATUS, UNI_ABOUT, USER_ID, KAKAO_ID)
    VALUES (17, '일반', 'User profile suspended', 17, 17);

    INSERT INTO GGHJ_UNI (UNI_ID, UNI_STATUS, UNI_ABOUT, USER_ID, KAKAO_ID)
    VALUES (18, '일반', 'User profile withdrawn', 18, 18);

    INSERT INTO GGHJ_UNI (UNI_ID, UNI_STATUS, UNI_ABOUT, USER_ID, KAKAO_ID)
    VALUES (19, '일반', 'Active user profile', 19, 19);

    INSERT INTO GGHJ_UNI (UNI_ID, UNI_STATUS, UNI_ABOUT, USER_ID, KAKAO_ID)
    VALUES (20, '일반', 'Inactive user profile', 20, 20);
   
    SELECT * FROM GGHJ_UNI;
   
    SELECT
            *
        FROM
            GGHJ_BOARD b JOIN GGHJ_USER u
                              ON u.user_id = b.USER_ID
        ORDER BY
            b.BOARD_LIKE_COUNT DESC;
           
           SELECT * FROM gghj_kakao;






    
    
    
    
    
    
    
>>>>>>> ba7783b6573a0df4537eea9c4fe0af6ba8e183d7
    