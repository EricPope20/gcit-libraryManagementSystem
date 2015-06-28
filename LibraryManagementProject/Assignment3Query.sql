/*This database is created by Eric Ackaah on June/23/2015 **/

/*This insert into the author table **/
insert into tbl_author 
values(07, 'Eric Pope'),(08, 'Belinda Darkwah'),(09, 'Olivia Ackaah'),
(10,'Samuel Gyapong'),(11,'Joseph Ackaah'),(12,'Agnes Arthur');

/* This insert into the library branch table**/
insert into tbl_library_branch 
values(01, 'Sharpstown', '24 state ave apt 201 VA'),
	  (02, 'Washington', '30 parkway street apt 20 WA'),
      (03, 'Byron', '25 state Dr apt 9 GA'),
      (04, 'Sharpstown', '109 Market place Drive NY'),
      (05, 'Warner Robins', '240 state ave apt 119 GA'),
      (06, 'McLean', '24 state ave apt 201 NJ');

/* This insert into the publisher table**/
insert into tbl_publisher 
values(01, 'Eric Pope', '24 state ave apt 201 VA', '222-333-6567'),
	  (02, 'Belinda Darkwah', '30 parkway street apt 20 WA','778-434-5679'),
      (03, 'Olivia Ackaah', '25 state Dr apt 9 GA', '478-213-5680'),
      (04, 'Samuel Gyapong', '109 Market place Drive NY', '798-990-1000'),
      (05, 'Joseph Ackaah', '240 state ave apt 119 GA', '474-213-3456'),
      (06, 'Agnes Arthur', '24 state ave apt 201 NJ','567-213-4901')

/*This insert into the Genre table **/
insert into tbl_genre 
values(01, 'Eric Pope'),(02, 'Belinda Darkwah'),(03, 'Olivia Ackaah'),
(04,'Samuel Gyapong'),(05,'Joseph Ackaah'),(06,'Agnes Arthur');

/* This insert into the borrower table**/
insert into tbl_borrower 
values(01, 'Eric Pope', '25 state ave apt 201 VA', '333-443-6567'),
	  (02, 'Belinda Darkwah', '20 parkway street apt 20 WA','978-434-5679'),
      (03, 'Olivia Ackaah', '15 state Dr apt 9 GA', '278-213-5680'),
      (04, 'Samuel Gyapong', '100 Market place Drive NY', '998-990-1000'),
      (05, 'Joseph Ackaah', '245 state ave apt 119 GA', '274-213-3456'),
      (06, 'Agnes Arthur', '200 state ave apt 201 NJ','967-213-4901')

/* This insert into the bookloans table**/
insert into tbl_book_loans
values(1, 1,1,'2015-06-24','2015-06-24','2014-12-10'tbl_booktbl_book),
	  (2, 2,2,'2015-12-10','2015-12-10','2015-12-10'),
      (3, 3,3,'2013-12-10','2013-12-10','2013-12-10'),
      (4, 4,4,'2012-12-10','2012-12-10','2012-12-10'),
      (5, 5,5,'2011-12-10','2011-12-10','2011-12-10'),
      (9, 6,6,'2010-12-10','2010-12-10','2010-12-10')
      
insert into tbl_book
values(7,'Individaul Right',7),(8, 'The Lost Tribe', 8),
	  (9, 'Life', 9),(10, 'Growth', 10)
      
insert into tbl_book_copies
values (1, 1, 1), (2,2,2),(3,3,3),(4,4,4),(5,5,5),(9,6,6)

insert into tbl_book_authors
values (7, 7,'Stephen King'), (8,8,'Addo Danquah'),(9,9,'John Oppong'),
	   (10,10,'Stephen King')

insert into tbl_book_genres 
values(01, 1),(02, 2),(03, 3),(04,4),(05,5),(06,9)

select * from tbl_library_branch;
select * from tbl_book_loans;
select * from tbl_book_copies;
select * from tbl_book;
select * from tbl_borrower;
select * from tbl_author;
select * from tbl_book_authors;



select * from ((((tbl_book NATURAL JOIN tbl_book_copies) NATURAL JOIN tbl_library_branch) NATURAL JOIN tbl_book_authors) NATURAL JOIN tbl_author);

select * from (tbl_book natural join tbl_book_copies) natural join tbl_book_authors;

select * from (tbl_library_branch natural join tbl_book_copies)
