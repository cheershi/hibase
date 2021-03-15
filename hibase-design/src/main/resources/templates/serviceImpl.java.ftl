package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
<#if (importServiceImplPackages?size>0) >
    <#list importServicePackages as pkg>
        import ${pkg};
    </#list>
</#if>
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageInfo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
* <p>
    * ${table.comment!} 服务实现类
    * </p>
*
* @author ${author}
* @since ${date}
*/
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
<#if kotlin>
    open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

    }
<#else>
    public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {

    /**
    * 查询${table.comment!}列表
    */
    @Override
    public PageInfo<${table.entityName}> select${table.entityName!}List(${table.entitySearchName} searchVO) {

    return super.page(searchVO, new QueryWrapper<${table.entityName}>());
    }

    /**
    * 改变${table.comment!}记录
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save${table.entityName!}(${table.entityName!} entity) {

    super.store(entity);
    }

    /**
    * 查询${table.comment!}详情
    */
    @Override
    public ${table.entityName} view${table.entityName!}(String id) {

    ${table.entityName} entity = super.getById(id, true);

    return entity;
    }

    /**
    * 删除${table.comment!}记录
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete${table.entityName!}(String id) {

    super.deleteBy(id);
    }
    }
</#if>
