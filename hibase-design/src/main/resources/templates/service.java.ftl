package ${package.Service};

<#if (importServicePackages?size>0) >
    <#list importServicePackages as pkg>
        import ${pkg};
    </#list>
</#if>
import ${package.Entity}.${entity};
import ${superServiceClassPackage};
import com.github.pagehelper.PageInfo;

/**
* <p>
    * ${table.comment!} 服务类
    * </p>
*
* @author ${author}
* @since ${date}
*/
<#if kotlin>
    interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
    public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

    /**
    * 查询${table.comment!}列表
    *
    * @param searchVO
    * @return
    */
    PageInfo<${table.entityName}> select${table.entityName!}List(${table.entitySearchName} searchVO);

    /**
    * 改变${table.comment!}记录
    *
    * @param entity
    * @return
    */
    void save${table.entityName!}(${table.entityName} entity);

    /**
    * 查询${table.comment!}详情
    *
    * @param id
    * @return
    */
    ${table.entityName} view${table.entityName!}(String id);

    /**
    * 删除${table.comment!}
    *
    * @param id
    */
    void delete${table.entityName!}(String id);
    }
</#if>
