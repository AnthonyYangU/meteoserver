package com.example.demo.utils;

import com.example.demo.entity.*;
import com.example.demo.mapper.AirportMapper;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeGenerator {
    public static String getInsertSql(Meteo meteo){
        Class meteoClass = meteo.getClass();
        String totalClassName = meteoClass.getName();
        String className = totalClassName.substring(totalClassName.lastIndexOf(".")+1);
//        System.out.println(className);
        Field[] fields = meteoClass.getDeclaredFields();
        String s = "insert into " + className.toLowerCase() + "s(";
        String values = " values(";

        if(meteoClass!= Meteo.class){
            Field[] meteoFields = Meteo.class.getDeclaredFields();
            for(Field f:meteoFields){
                f.setAccessible(true);
                if(f.getName()!="id"){
                    s = s + f.getName() + ",";
                    values = values + "#{" + className.toLowerCase() + "." + f.getName() + "},";
                }
            }
        }

        for (Field f : fields) {
            f.setAccessible(true);
            if(f.getName()!="id"){
                s = s + f.getName() + ",";
                values = values + "#{" + className.toLowerCase() + "." + f.getName() + "},";
            }
        }
        s = s.substring(0,s.length()-1) + ")";
        values = values.substring(0,values.length()-1) + ")";
        return s + values;
    }

    public static String getUpdate(Meteo meteo,String type){
        Class meteoClass = meteo.getClass();
        String totalClassName = meteoClass.getName();
        String className = totalClassName.substring(totalClassName.lastIndexOf(".")+1).toLowerCase();
//        System.out.println(className);
        Field[] fields = meteoClass.getDeclaredFields();
        String s = "update " + className + "s set ";

        if(meteoClass!=Meteo.class){
            Field[] meteoFields = Meteo.class.getDeclaredFields();
            for(Field f:meteoFields){
                f.setAccessible(true);
                if(f.getName()!="id" &&f.getName()!=type){
                    s = s + f.getName() + "= #{" + className + "." + f.getName() + "},";
                }
            }
        }

        for (Field f : fields) {
            f.setAccessible(true);
            if(f.getName()!="id" &&f.getName()!=type){
                s = s + f.getName() + "= #{" + className + "." + f.getName() + "},";
            }
        }
        s = s.substring(0,s.length()-1) + " where " +  type + "=#{" + className + "." + type + "}";
        return s;
    }



    public static void getMapperCode(Meteo meteo){
        Class meteoClass = meteo.getClass();
        String totalClassName = meteoClass.getName();
        String className = totalClassName.substring(totalClassName.lastIndexOf(".")+1);
        Map map = Map.of("className",className,"classname",className.toLowerCase());
        try (Writer writer = new FileWriter("target/generatedMapper/" + className + "Mapper.java", StandardCharsets.UTF_8)) {
            writer.write("@Mapper\n");
            writer.write("@Repository\n");
            writer.write("public interface " + className + "Mapper {\n");
            writer.write("    @Options(useGeneratedKeys = true, keyProperty = \"id\", keyColumn = \"id\")\n");
            writer.write("    @Insert(\"" + getInsertSql(meteo)+"\")" + "\n");
            writer.write(stringFromTemplate("    void insert(@Param(\"${classname}\") ${className} ${classname});\n",map));
            writer.write("\n");

            writer.write(stringFromTemplate("    @Select(\"select * from ${classname}s where id=#{id}\")\n",map));
            writer.write(stringFromTemplate("    ${className} getById(@Param(\"id\") Long id);\n",map));
            writer.write("\n");

            writer.write(stringFromTemplate("    @Select(\"select * from ${classname}s where airportCode=#{airportCode}\")\n",map));
            writer.write(stringFromTemplate("    List<${className}> getByAirportCode(@Param(\"airportCode\") Integer airportCode);\n",map));
            writer.write("\n");

            writer.write(stringFromTemplate("    @Select(\"select * from ${classname}s where airportName=#{airportName}\")\n",map));
            writer.write(stringFromTemplate("    List<${className}> getByAirportName(@Param(\"airportName\") String airportName);\n",map));
            writer.write("\n");

            writer.write(stringFromTemplate("    @Select(\"select * from ${classname}s where imeiId=#{imeiId}\")\n",map));
            writer.write(stringFromTemplate("    List<${className}> getByImeiId(@Param(\"imeiId\") Integer imeiId);\n",map));
            writer.write("\n");

            writer.write(stringFromTemplate("    @Select(\"select * from ${classname}s where imeiId=#{imeiId} and sensorId=#{sensorId}\")\n",map));
            writer.write(stringFromTemplate("    ${className} getByImeiAndSensorId(@Param(\"imeiId\") Integer imeiId, @Param(\"sensorId\") Integer sensorId);\n",map));
            writer.write("\n");

            writer.write(stringFromTemplate("    @Select(\"select * from ${classname}s\")\n",map));
            writer.write(stringFromTemplate("    List<${className}> getAll();\n",map));
            writer.write("\n");

            writer.write("    @Update(\""+ getUpdate(meteo,"airportCode") + "\")\n");
            writer.write(stringFromTemplate("    void updateByAirportCode(@Param(\"${classname}\") ${className} ${classname});\n",map));
            writer.write("\n");

            writer.write("    @Update(\""+ getUpdate(meteo,"airportName") + "\")\n");
            writer.write(stringFromTemplate("    void updateByAirportName(@Param(\"${classname}\") ${className} ${classname});\n",map));
            writer.write("\n");

            writer.write("    @Update(\""+ getUpdate(meteo,"id") + "\")\n");
            writer.write(stringFromTemplate("    void updateById(@Param(\"${classname}\") ${className} ${classname});\n",map));
            writer.write("\n");

            writer.write("    @Update(\""+ getUpdate(meteo,"imeiId") + "\")\n");
            writer.write(stringFromTemplate("    void updateByImeiId(@Param(\"${classname}\") ${className} ${classname});\n",map));
            writer.write("\n");

            writer.write("    @Update(\""+ getUpdate(meteo,"imeiId")+stringFromTemplate(" and sensorId=#{${classname}.sensorId}",map) + "\")\n");
            writer.write(stringFromTemplate("    void updateByImeiAndSensorId(@Param(\"${classname}\") ${className} ${classname});\n",map));
            writer.write("\n");

            writer.write(stringFromTemplate("    @Delete(\"delete from ${classname}s where airportCode=#{airportCode}\")\n",map));
            writer.write("    void deleteByAirportCode(@Param(\"airportCode\") Integer airportCode);\n");
            writer.write("\n");

            writer.write(stringFromTemplate("    @Delete(\"delete from ${classname}s where airportName=#{airportName}\")\n",map));
            writer.write("    void deleteByAirportName(@Param(\"airportName\") Integer airportName);\n");
            writer.write("\n");

            writer.write(stringFromTemplate("    @Delete(\"delete from ${classname}s where id=#{id}\")\n",map));
            writer.write("    void deleteById(@Param(\"id\") Long id);\n");
            writer.write("\n");

            writer.write(stringFromTemplate("    @Delete(\"delete from ${classname}s where imeiId=#{imeiId}\")\n",map));
            writer.write("    void deleteByImeiId(@Param(\"imeiId\") Integer imeiId);\n");
            writer.write("\n");

            writer.write("}");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String stringFromTemplate(String s, Map<String,String> map){
        var sb = new StringBuilder();

        Pattern p = Pattern.compile("\\$\\{(\\w+)\\}");

        Matcher m = p.matcher(s);

        while(m.find()){
//            System.out.println(m.group(1));
//            将上次替换的位置到这次替换的位置之间的字符串和这次替换之后的结果，一起追加到StringBuilder
            m.appendReplacement(sb,map.get(m.group(1)));
        }
        //将最后一次匹配之后的内容添加到字符串缓存
        m.appendTail(sb);
//        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void getControllerCode(Meteo meteo) {

        Class meteoClass = meteo.getClass();
        String totalClassName = meteoClass.getName();
        String className = totalClassName.substring(totalClassName.lastIndexOf(".") + 1);
        Map map = Map.of("className", className, "classname", className.toLowerCase(),"classMapper",className.toLowerCase()+"Mapper");
        try (Writer writer = new FileWriter("target/generatedController/" + className + "Controller.java", StandardCharsets.UTF_8)) {
            writer.write("@RestController\n");
            writer.write("@RequestMapping(\"/api\")");
            writer.write(stringFromTemplate("public class ${className}Controller {\n",map));
            writer.write("    @Autowired\n");
            writer.write(stringFromTemplate("    private ${className}Mapper ${classname}Mapper;\n",map));
            writer.write("\n");
            writer.write(stringFromTemplate("    @PostMapping(\"/insert${className}Info\")\n",map));
            writer.write(stringFromTemplate("    public ${className} insert${className}Info(@RequestBody ${className} ${classname}){\n",map));
            writer.write(stringFromTemplate("        if(${classname}Mapper.getByAirportCode(${classname}.getAirportCode())==null){\n",map));
            writer.write(stringFromTemplate("            ${classname}Mapper.insert(${classname});\n",map));
            writer.write(stringFromTemplate("            return ${classname};\n",map));
            writer.write("        }else{\n");
            writer.write("            return null;\n");
            writer.write("        }\n");
            writer.write("    }\n");
            writer.write("\n");
            writer.write(stringFromTemplate("    @GetMapping(\"/get${className}ById/{id}\")\n",map));
            writer.write(stringFromTemplate("    public ${className} getById(@PathVariable(\"id\") long id){\n",map));
            writer.write(stringFromTemplate("        return ${classMapper}.getById(id);\n",map));
            writer.write(stringFromTemplate("    }\n",map));
            writer.write("\n");
            writer.write(stringFromTemplate("    @GetMapping(\"/get${className}ByName/{airportName}\")\n",map));
            writer.write(stringFromTemplate("    public List<${className}> getByAirportName(@PathVariable(\"airportName\") String airportName){\n",map));
            writer.write(stringFromTemplate("        return ${classMapper}.getByAirportName(airportName);\n",map));
            writer.write("    }\n");
            writer.write("\n");
            writer.write(stringFromTemplate("    @GetMapping(\"/get${className}ByImeiId/{imeiId}\")\n",map));
            writer.write(stringFromTemplate("    public List<${className}> getByImeiId(@PathVariable(\"imeiId\") Integer imeiId){\n",map));
            writer.write(stringFromTemplate("        return ${classMapper}.getByImeiId(imeiId);\n",map));
            writer.write("    }\n");
            writer.write("\n");
            writer.write(stringFromTemplate("    @GetMapping(\"/get${className}\")\n",map));
            writer.write(stringFromTemplate("    public List<${className}> findAll(){\n",map));
            writer.write(stringFromTemplate("        return ${classMapper}.getAll();\n",map));
            writer.write("    }\n");
            writer.write("\n");
            writer.write(stringFromTemplate("    @PostMapping(\"/update${className}ById\")\n",map));
            writer.write(stringFromTemplate("    public Map<String,Integer> updateById(@RequestBody ${className} ${classname}) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException{\n",map));
            writer.write(stringFromTemplate("        CodeGenerator.getSpecificUpdate(${classname},${classMapper}.getById(${classname}.getId()));\n",map));
            writer.write(stringFromTemplate("        ${classMapper}.updateById(${classname});\n",map));
            writer.write("        return Map.of(\"status\",0);\n");
            writer.write("    }\n");
            writer.write("\n");
            writer.write(stringFromTemplate("    @PostMapping(\"/update${className}ByImeiAndSensorId\")\n",map));
            writer.write(stringFromTemplate("    public Map<String,Integer> updateByImeiAndSensorId(@RequestBody ${className} ${classname}) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {\n",map));
            writer.write(stringFromTemplate("        CodeGenerator.getSpecificUpdate(${classname},${classMapper}.getByImeiAndSensorId(${classname}.getImeiId(),${classname}.getSensorId()));\n",map));
            writer.write(stringFromTemplate("        ${classMapper}.updateByImeiAndSensorId(${classname});\n",map));
            writer.write("        return Map.of(\"status\",0);\n");
            writer.write("    }\n");
            writer.write("\n");
            writer.write(stringFromTemplate("    @PostMapping(\"/delete${className}ById\")\n",map));
            writer.write("    public Map<String,Integer> deleteById(@RequestBody long id){\n");
            writer.write(stringFromTemplate("        ${classMapper}.deleteById(id);\n",map));
            writer.write("        return Map.of(\"status\",0);\n");
            writer.write("    }\n");
            writer.write("}\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //将meteo1中null属性用meteo2中同属性的值代替
    public static void getSpecificUpdate(Object meteo1,Object meteo2) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
//        if(meteo1.getClass()!=meteo2.getClass())
//            return;
        Class meteo1Class = meteo1.getClass();
        Class meteo1Super = meteo1Class.getSuperclass();
        Field[] meteoSuperFields = meteo1Super.getDeclaredFields();
        for (Field f : meteoSuperFields){
            f.setAccessible(true);
            String fieldName = f.getName();
            var type = f.getType();
//            System.out.println(type);
            if(f.get(meteo1)==null){
                String method1Name = "set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
                Method method1 = meteo1Class.getMethod(method1Name,type);
                String method2Name = "get" + fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
                Method method2 = meteo1Class.getMethod(method2Name);
                var method2Value = method2.invoke(meteo2);
                method1.invoke(meteo1,method2Value);
            }
        }

        Field[] fields = meteo1Class.getDeclaredFields();
        for (Field f : fields){
            f.setAccessible(true);
            String fieldName = f.getName();
            var type = f.getType();
            if(f.get(meteo1)==null){
                String method1Name = "set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
                Method method1 = meteo1Class.getMethod(method1Name,type);
                String method2Name = "get" + fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
                Method method2 = meteo1Class.getMethod(method2Name);
                var method2Value = method2.invoke(meteo2);
                method1.invoke(meteo1,method2Value);
            }
        }
    }
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
//        CodeGenerator.getMapperCode(new Humitemp());
//        CodeGenerator.getMapperCode(new Cloud());
//        CodeGenerator.getMapperCode(new Humitemp());
//        CodeGenerator.getMapperCode(new Meteo());
//        CodeGenerator.getMapperCode(new Press());
//
//        CodeGenerator.getMapperCode(new Pv());
//        CodeGenerator.getMapperCode(new Pw());
//        CodeGenerator.getMapperCode(new Rain());
//        CodeGenerator.getMapperCode(new Rosa());
//        CodeGenerator.getMapperCode(new Rwylights());
//        CodeGenerator.getMapperCode(new Vis());
//        CodeGenerator.getMapperCode(new Wind());

//        CodeGenerator.getControllerCode(new Humitemp());
//        CodeGenerator.getControllerCode(new Cloud());
//        CodeGenerator.getControllerCode(new Humitemp());
//        CodeGenerator.getControllerCode(new Meteo());
//        CodeGenerator.getControllerCode(new Press());
//
//        CodeGenerator.getControllerCode(new Pv());
//        CodeGenerator.getMapperCode(new Pw());
//        CodeGenerator.getControllerCode(new Rain());
//        CodeGenerator.getControllerCode(new Rosa());
//        CodeGenerator.getControllerCode(new Rwylights());
//        CodeGenerator.getControllerCode(new Vis());
//        CodeGenerator.getControllerCode(new Wind());

//        Meteo meteo = new Press();
//        meteo.setAirportCode(172);
//        meteo.setId((long) 11);
//        Press meteo2 = new Press();
//        meteo2.setMessageType("test");
//        meteo2.setAlt((double) 100);
//        CodeGenerator.getSpecificUpdate(meteo,meteo2);
//        System.out.println(meteo.getAirportCode());
//        System.out.println(meteo);
//
//        Airport airport1 = new Airport();
//        airport1.setAirportCode(111);
//        Airport airport2 = new Airport();
//        airport2.setAirportName("t");
//        CodeGenerator.getSpecificUpdate(airport1,airport2);
//        System.out.println(airport1.getAirportName());
    }
}
