/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Analyzer;

/**
 *
 * @author diego
 */
public class SymNode {
    private String name;
    private String role;
    private String type;
    private String environment;
    private String belongs_to;
    private Object value;
    private String line;
    private String column;

    public SymNode(String name, String role, String type, String environment, String belongs_to, Object value, String line, String column) {
        this.name = name;
        this.role = role;
        this.type = type;
        this.environment = environment;
        this.belongs_to = belongs_to;
        this.value = value;
        this.line = line;
        this.column = column;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getBelongs_to() {
        return belongs_to;
    }

    public void setBelongs_to(String belongs_to) {
        this.belongs_to = belongs_to;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    @Override
    public String toString() {
        return "SymNode{" + "name=" + name + ", role=" + role + ", type=" + type + ", environment=" + environment + ", belongs_to=" + belongs_to + ", value=" + value + ", line=" + line + ", column=" + column + '}';
    }
    
    
   
    
   
}
