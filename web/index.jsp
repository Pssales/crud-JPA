<%-- 
    Document   : index
    Created on : 11/09/2018, 19:43:00
    Author     : a1600222
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Biblioteca"%>
<%@page import="model.Livro"%>
<%@page import="model.Autor"%>
<%@page import="javax.persistence.EntityTransaction"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
        Biblioteca b = new Biblioteca();
        b.setNome("Biblioteca Central I");
        
        Biblioteca b2 = new Biblioteca();
        b2.setNome("Biblioteca Central II");
        
        Autor a = new Autor();
        a.setNome("J.K. Rowling");

        Livro l = new Livro();
        l.setNome("Harry Potter and the Philosopher’s Stone");
        l.setEdicao(2);
        l.setBiblioteca(b);
        
        Livro l2 = new Livro();
        l2.setNome("Harry Potter and the Chamber of Secrets");
        l2.setEdicao(1);
        l.setBiblioteca(b2);
        
        List<Livro> livros = new ArrayList<Livro>(); 
        livros.add(l);
        livros.add(l2);
        
       
        
        a.setLivros(livros);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MirantePU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(l);    
        et.commit();
        em.close();
        emf.close();       
  
        %>
    </body>
</html>
