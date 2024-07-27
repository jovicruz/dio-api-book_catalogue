# dio-api-springboot
Api REST para catalogo de livros, com funções de criação, atualização, exclusão e pesquisar.
<br>
<h2>Diagrama da classe<h2>
  
```mermaid
classDiagram
    class Book {
        int id
        string name
        string pub_date
        string author
        int total_pages
        int current_page
        string status
        int rating
        string cover_img
    }
