--書籍情報
INSERT INTO books(book_name,author,publisher,price,isbn,num_of_books,book_image_url)
VALUES ('熊 他三篇','W・フォークナー','岩波文庫',780,9784003232330,1,'https://ndlsearch.ndl.go.jp/thumbnail/9784003232330.jpg');

INSERT INTO books(book_name,author,publisher,price,isbn,num_of_books,book_image_url)
VALUES ('サンクチュアリ','W・フォークナー','新潮文庫',630,9784102102022,1,'https://ndlsearch.ndl.go.jp/thumbnail/9784102102022.jpg');

INSERT INTO books(book_name,author,publisher,price,isbn,num_of_books,book_image_url)
VALUES ('フォークナー短編集','W・フォークナー','岩波文庫',550,9784102102039,1,'https://ndlsearch.ndl.go.jp/thumbnail/9784102102039.jpg');

INSERT INTO books(book_name,author,publisher,price,isbn,num_of_books,book_image_url)
VALUES ('「また、あなたに頼みたい」と言われる提案のしかた','吉澤浩一郎 (著), 山口華乃 (著), 石井香帆 (著)','クロスメディア・パブリッシング(インプレス)',1628,9784295409557,1,'/img/noimage.png');

INSERT INTO books(book_name,author,publisher,price,isbn,num_of_books,book_image_url)
VALUES ('スッキリわかるJava入門 第4版 (スッキリわかる入門シリーズ)','中山 清喬 (著), 国本 大悟 (著), 株式会社フレアリンク (監修)','インプレス',2970,9784295017936,1,'/img/noimage.png');

INSERT INTO books(book_name,author,publisher,price,isbn,num_of_books,book_image_url)
VALUES ('プロになるJava―仕事で必要なプログラミングの知識がゼロから身につく最高の指南書','きしだ なおき (著), 山本 裕介 (著), 杉山 貴章 (著)','技術評論社',3278,9784297126858,1,'https://ndlsearch.ndl.go.jp/thumbnail/9784297126858.jpg');

INSERT INTO books(book_name,author,publisher,price,isbn,num_of_books,book_image_url)
VALUES ('Java［完全］入門','松浦健一郎 (著), 司ゆき (著)','SBクリエイティブ',2948,9784815619244,1,'https://ndlsearch.ndl.go.jp/thumbnail/9784815619244.jpg');

INSERT INTO books(book_name,author,publisher,price,isbn,num_of_books,book_image_url)
VALUES ('JavaエンジニアのためのEclipse パーフェクトガイド【増補改訂版】','横田 一輝 (著)','技術評論社',3278,9784297132040,1,'https://ndlsearch.ndl.go.jp/thumbnail/9784297132040.jpg');

INSERT INTO books(book_name,author,publisher,price,isbn,num_of_books,book_image_url)
VALUES ('基礎＆応用力をしっかり育成！Androidアプリ開発の教科書 第3版 Java対応 なんちゃって開発者にならないための実践ハンズオン','WINGSプロジェクト 齊藤 新三 (著), 山田 祥寛 (監修)','翔泳社',3135,9784798176314,1,'https://ndlsearch.ndl.go.jp/thumbnail/9784798176314.jpg');

INSERT INTO books(book_name,author,publisher,price,isbn,num_of_books,book_image_url)
VALUES ('Spring徹底入門 第2版 Spring FrameworkによるJavaアプリケーション開発','株式会社NTTデータ (著), 株式会社NTTデータグループ (編集)','翔泳社',4730,9784798181349,1,'https://ndlsearch.ndl.go.jp/thumbnail/9784798181349.jpg');

INSERT INTO books(book_name,author,publisher,price,isbn,num_of_books,book_image_url)
VALUES ('新わかりやすいJava 入門編 第3版','川場隆 (著)','秀和システム',2860,9784798067759,1,'https://ndlsearch.ndl.go.jp/thumbnail/9784798067759.jpg');

--レビュー
INSERT INTO reviews(emp_id,rating,comment,book_id,created_at,updated_at)
VALUES ('soumutarou',5,'最高の本でした。',1,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

INSERT INTO reviews(emp_id,rating,comment,book_id,created_at,updated_at)
VALUES ('ippantarou',5,'控えめに言って最高。',2,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

INSERT INTO reviews(emp_id,rating,comment,book_id,created_at,updated_at)
VALUES ('ippantarou',3,'普通の読後感でした。',3,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

INSERT INTO reviews(emp_id,rating,comment,book_id,created_at,updated_at)
VALUES ('ippanjirou',4,'最高の本でした',1,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

--社員情報
INSERT INTO employees(emp_name,emp_id,password,dep_id)
VALUES ('総務太郎','soumutarou','soumu1',1);

INSERT INTO employees(emp_name,emp_id,password,dep_id)
VALUES ('一般太郎','ippantarou','ippan1',2);

INSERT INTO employees(emp_name,emp_id,password,dep_id)
VALUES ('一般次郎','ippanjirou','ippan2',3);


--部署
INSERT INTO departments(dep_name)
VALUES ('総務部');

INSERT INTO departments(dep_name)
VALUES ('人事部');

INSERT INTO departments(dep_name)
VALUES ('開発部');