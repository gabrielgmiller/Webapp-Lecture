<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8"/>
  <title>Products</title>
</head>
<body>

<h2>Products</h2>

<table>
  <thead>
    <tr>
      <th>Title</th>
      <th>First Author</th>
      <th>Actions</th>
    </tr>
  </thead>

  <tbody>
  <#list products as p>
    <tr>
      <td>${p.title}</td>
      <td>${p.firstAuthor}</td>
      <td>
        <form method="post" action="/addToCart" style="display:inline;">
          <input type="hidden" name="id" value="${p.id}"/>
          <button type="submit">Add</button>
        </form>

        <form method="get" action="/bookDetails" style="display:inline;">
          <input type="hidden" name="id" value="${p.id}"/>
          <input type="hidden" name="from" value="products"/>
          <button type="submit">Details</button>
        </form>
      </td>
    </tr>
  </#list>
  </tbody>
</table>

</body>
</html>
