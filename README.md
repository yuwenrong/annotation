# secret-body


curl --location 'localhost:8080/secret/test/testEncrypt' \
--header 'Content-Type: application/json' \
--data '{
"message":"abcdefghjklmnopqrstuvwxyz"
}'



curl --location 'localhost:8080/secret/test/testDecrypt' \
--header 'Content-Type: application/json' \
--data '{
"message":"NyMsMArL9abUs+dfK9eNkvoHoaWP/bb+G8M8peSZmVEW8Ja02yBE6qLYMdKtH9+jUuEcPIsJQEcULito20APgZGm8ZDtpZVs2XJIiiST2pzU/QK1RvDucjDLrd7epHXYVml/KOO96/NfyOHp0lWr0cXFKafYM8bZ/WoHeMPCua1A066/6BiWcWS1pOqMoqZLfqDEFjIptYGKm4HOFqxhmtclIJOvC1ibXIrZfCZFZh504wKC9ElrWYdc3GJOddYlkDVGqfJPKtsiBG1CpVnO9QHzrgS/yAFmhsqMn4KpVaK/TYzM8SawMGLp0BtDi20Kiny0tE7P4iiO3wI7C9t4ig=="
}'