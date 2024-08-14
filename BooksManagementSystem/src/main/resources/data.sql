--書籍情報
INSERT INTO books(book_name,author,publisher,price,isbn,num_of_books,book_image_url)
VALUES ('熊 他三篇','W・フォークナー','岩波文庫',780,9784003232330,1,'https://ndlsearch.ndl.go.jp/thumbnail/9784003232330.jpg');

INSERT INTO books(book_name,author,publisher,price,isbn,num_of_books,book_image_url)
VALUES ('サンクチュアリ','W・フォークナー','新潮文庫',630,9784102102022,1,'https://ndlsearch.ndl.go.jp/thumbnail/9784102102022.jpg');

INSERT INTO books(book_name,author,publisher,price,isbn,num_of_books,book_image_url)
VALUES ('フォークナー短編集','W・フォークナー','岩波文庫',550,9784102102039,1,'https://ndlsearch.ndl.go.jp/thumbnail/9784102102039.jpg');

--レビュー
INSERT INTO reviews(emp_id,rating,comment,book_id,created_at,updated_at)
VALUES (1,5,'最高の本でした。',1,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

INSERT INTO reviews(emp_id,rating,comment,book_id,created_at,updated_at)
VALUES (2,5,'控えめに言って最高。',2,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

INSERT INTO reviews(emp_id,rating,comment,book_id,created_at,updated_at)
VALUES (2,3,'普通の読後感でした。',3,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

INSERT INTO reviews(emp_id,rating,comment,book_id,created_at,updated_at)
VALUES (2,4,'最高の本でした',1,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

--社員情報
INSERT INTO employees(emp_name,emp_id,password,dep_id)
VALUES ('総務太郎','soumutarou','soumu1',1);

INSERT INTO employees(emp_name,emp_id,password,dep_id)
VALUES ('一般太郎','ippantarou','ippan1',2);

INSERT INTO employees(emp_name,emp_id,password,dep_id)
VALUES ('一般次郎','ippanjirou','ippan2',3);

--部署
INSERT INTO depertments(dep_name)
VALUES ('総務部');

INSERT INTO depertments(dep_name)
VALUES ('人事部');

INSERT INTO depertments(dep_name)
VALUES ('開発部');