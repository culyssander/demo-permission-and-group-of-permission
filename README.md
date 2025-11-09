# Demo Permission

### VIEW DIAGRAM
![diagram](image/demo.png)

To validate whether a user can perform a function, you can add this method.

``permissionService.validatePermission(userLogged().getUserId(), PERMISSION_CREATE_DEFAULT_USER);``

