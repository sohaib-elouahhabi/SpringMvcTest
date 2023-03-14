package com.example.SpringMvcTest.DAO;

import com.example.SpringMvcTest.models.Produit;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ImpProduitDao implements IProduit{
    JdbcTemplate template;
    String sql;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public int save(Produit p) {
        sql = "insert into produit (designation, prix, quantite) values (?, ?, ?)";
        return template.update(sql, p.getDesignation(), p.getPrix(), p.getQuantite());
    }
    public void edit(Produit p) {
        sql="update produit set designation='"+p.getDesignation()+"',prix='"+p.getPrix()+
                "',quantite='"+p.getQuantite()+"' where id='"+p.getId()+"';";
        template.update(sql);

    }
    public int delete(int code) {
        sql = "delete from produit where id="+code;
        return template.update(sql);
    }
    public Produit getProduitById(int code){
        String sql="select * from produit where id=?";
        return template.queryForObject(sql, new Object[]{code},new BeanPropertyRowMapper<Produit>(Produit.class));
    }

    public List<Produit> getProduits(){
        return template.query("select * from produit",new RowMapper<Produit>(){
            public Produit mapRow(ResultSet rs, int row) throws SQLException {
                Produit prd=new Produit();
                prd.setId(rs.getInt(1));
                prd.setDesignation(rs.getString(2));
                prd.setPrix(rs.getFloat(3));
                prd.setQuantite(rs.getInt(4));
                return prd;
            }
        });
    }
}

