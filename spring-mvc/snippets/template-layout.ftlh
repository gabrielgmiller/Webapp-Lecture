<#-- Minimal layout idea. Adapt to your project template.flth / template.ftlh naming -->
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8"/>
  <title>${title!"WebApp"}</title>
</head>
<body>

  <div>
    <a href="/products">Products</a> |
    <a href="/shoppingCart">Shopping Cart</a>
  </div>

  <hr/>

  <#-- Flash messages -->
  <#if success??>
    <div>${success}</div>
  </#if>
  <#if error??>
    <div>${error}</div>
  </#if>

  <#-- Content -->
  <#nested>

  <hr/>
  <div>© Web Applications</div>

</body>
</html>
