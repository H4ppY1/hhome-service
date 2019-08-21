package com.happy.hhome.init;


import com.happy.hhome.bean.UserDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class UpdateTable implements ApplicationRunner {

    private final static String UPDATETABLE = "on";

    @Value("${updatetable.switch}")
    private String updateTableSwitch;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if(UPDATETABLE.equals(updateTableSwitch)) {
            log.error("yelaile");
            createTable(UserDO.class);
        }
    }


    public static Map<String, String> javaProperty2SqlColumnMap = new HashMap<>();

    static {
        javaProperty2SqlColumnMap.put("Integer", "INTEGER");
        javaProperty2SqlColumnMap.put("Short", "tinyint");
        javaProperty2SqlColumnMap.put("Long", "bigint");
        javaProperty2SqlColumnMap.put("BigDecimal", "decimal(19,2)");
        javaProperty2SqlColumnMap.put("Double", "double precision not null");
        javaProperty2SqlColumnMap.put("Float", "float");
        javaProperty2SqlColumnMap.put("Boolean", "bit");
        javaProperty2SqlColumnMap.put("Timestamp", "datetime");
        javaProperty2SqlColumnMap.put("String", "VARCHAR(255)");
    }

    public String createTable(Class obj) throws IOException {

        Table table = (Table) obj.getAnnotation(Table.class);
        String tableName = table.name();
        StringBuilder sb = new StringBuilder();
        sb.append("create table ").append(tableName).append(" ( ");

        List<String> primaryKeyList = new ArrayList<>();
        Field[] fields = obj.getDeclaredFields();

        for (Field field : fields) {
            Id id = field.getAnnotation(Id.class);
            if (null != id) {
                primaryKeyList.add(field.getName());
            }
            Column column = field.getAnnotation(Column.class);
            Object type = field.getType();
            String columnType = "";
            if (type.equals(Integer.class)) {
                columnType = " INTEGER";
            } else if (type.equals(BigDecimal.class)) {
                columnType = " decimal(19,2)";
            } else if (type.equals(String.class)) {
                columnType = " varchar(64)";
            } else if (type.equals(Short.class)) {
                columnType = " tinyint";
            } else if (type.equals(Long.class)) {
                columnType = " bigint";
            } else if (type.equals(Double.class)) {
                columnType = " double precision not null";
            } else if (type.equals(Float.class)) {
                columnType = " float";
            } else if (type.equals(Boolean.class)) {
                columnType = " bit";
            } else if (type.equals(Timestamp.class)) {
                columnType = " datetime";
            } else {
                continue;
            }
            sb.append(field.getName()).append(" ").append(columnType).append(", ");
        }
        sb.delete(sb.length()-2, sb.length()-1);
        sb.append(")ENGINE =INNODB DEFAULT  CHARSET= utf8;");
        log.error(sb.toString());

        return null;
    }
}
