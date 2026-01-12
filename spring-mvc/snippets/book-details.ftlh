<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8"/>
  <title>Book Details</title>
</head>
<body>

<h2>Book Details</h2>

<#-- Adapt fields based on the Book model -->
<div><b>Title:</b> ${book.title}</div>
<div><b>ISBN:</b> ${book.isbn}</div>
<div><b>Publisher:</b> ${book.publisher}</div>
<div><b>Language:</b> ${book.language}</div>
<div><b>Pages:</b> ${book.numberOfPages}</div>
<div><b>Price:</b> ${book.price}</div>
<div><b>Published at:</b> ${book.publishedAt}</div>

<hr/>

<form method="post" action="/bookDetails/back">
  <input type="hidden" name="from" value="${from!""}"/>
  <button type="submit">${backLabel!"Back"}</button>
</form>

</body>
</html>
