/*This database is created by Eric Ackaah, on Jun/2015 

Answer to the first question **/
select noOfCopies b, title, branchName
from tbl_book_copies, tbl_book, tbl_library_branch
where title = 'The Lost Tribe' and branchName = 'Sharpstown'
group by title having count(*)>1

/*select branchName, noOfCopies
from tbl_book, tbl_book_copies, tbl_library_branch
where title = 'The Lost Tribe'; **/

/*Answer to the first question alternative **/
SELECT noOfCopies,bookId
FROM ((tbl_book NATURAL JOIN tbl_book_copies) NATURAL JOIN tbl_library_branch)
WHERE title='The Lost Tribe' and branchName='Sharpstown'; 

/*Answer to the second question **/
SELECT branchName, noOfCopies
FROM ((tbl_book natural join tbl_book_copies) natural join tbl_library_branch)
WHERE title='The Lost Tribe'; 

/*Answer to the third question **/
select name
from tbl_borrower b
where not exists(select * from tbl_book_loans l
				where b.cardNo = l.cardNo);

/*Answer to fourth question **/
SELECT B.title, R.name, R.address
FROM tbl_book B, tbl_borrower R, tbl_book_loans BL, tbl_library_branch LB
WHERE LB.branchName='Sharpstown' AND LB.branchId=BL.branchId AND
BL.dueDate='2015-06-24' AND BL.cardNo=R.cardNo AND BL.bookId=B.bookId

/*This is ansswer to fifth question **/
SELECT L.branchName, COUNT(*)
FROM  tbl_library_branch L, tbl_book_loans BL
WHERE BL.branchId = L.branchId
GROUP BY L.branchName;

/*this is answer to sixth question**/
SELECT B.name, B.address, count(*)
FROM  tbl_borrower B, tbl_book_loans L
WHERE B.cardNo = L.cardNo 
GROUP BY B.cardNo, B.name, B.address
HAVING COUNT(*) > 5;

/*this is answer to seventh question**/
SELECT title, noOfCopies
FROM   (((tbl_book_authors NATURAL JOIN tbl_book) NATURAL JOIN tbl_book_copies) 
		NATURAL JOIN tbl_library_branch)
WHERE authorName='Stephen King' AND branchName='Central';