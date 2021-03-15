package ${package.Controller};

import com.hibase.common.utils.EntityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.ApiOperation;
import com.hibase.baseweb.core.web.annotation.HibasePostRequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.github.pagehelper.PageInfo;
import com.hibase.baseweb.core.web.ResponseModel;
import com.hibase.baseweb.model.OperationIdEntity;
<#if (importControllerPackages?size>0) >
    <#list importControllerPackages as pkg>
        import ${pkg};
    </#list>
</#if>
<#if restControllerStyle>
    import org.springframework.web.bind.annotation.RestController;
<#else>
    import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
    import ${superControllerClassPackage};
</#if>

/**
* <p>
    * ${table.comment!} 前端控制器
    * </p>
*
* @author ${author}
* @since ${date}
*/
<#if restControllerStyle>
    @RestController
<#else>
    @Controller
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
@Api(tags = "${table.comment!}")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
    public class ${table.controllerName} extends ${superControllerClass} {
<#else>
    public class ${table.controllerName} {

</#if>

@Autowired
private ${table.serviceName} ${table.serviceAliasName};

@ApiOperation(value = "查询${table.comment!}列表", httpMethod = "POST")
@HibasePostRequestMapping(value = "select${table.entityName!}List")
public ResponseModel<${table.entityVoName}> select${table.entityName!}List(@RequestBody ${table.entitySearchName} searchVO) {

PageInfo result = ${table.serviceAliasName}.select${table.entityName!}List(searchVO);

result.setList(EntityUtils.transform(result.getList(), ${table.entityVoName}.class));

return super.successMsg(result);
}

@ApiOperation(value = "新增${table.comment!}记录", httpMethod = "POST")
@HibasePostRequestMapping(value = "insert${table.entityName!}")
public ResponseModel<String> insert${table.entityName!}(@RequestBody ${table.entityInsertName} insertVO) {

    ${table.entityName} entity = EntityUtils.transform(insertVO, ${table.entityName}.class);

    ${table.serviceAliasName}.save${table.entityName!}(entity);

    return super.successMsg(entity.getId());
    }

    @ApiOperation(value = "修改${table.comment!}记录", httpMethod = "POST")
    @HibasePostRequestMapping(value = "update${table.entityName!}")
    public ResponseModel<String> update${table.entityName!}(@RequestBody ${table.entityUpdateName} updateVO) {

        ${table.entityName} entity = EntityUtils.transform(updateVO, ${table.entityName}.class);

        ${table.serviceAliasName}.save${table.entityName!}(entity);

        return super.successMsg(entity.getId());
        }

        @ApiOperation(value = "查询${table.comment!}详情", httpMethod = "POST")
        @HibasePostRequestMapping(value = "view${table.entityName!}Details")
        public ResponseModel<${table.entityViewName}> view${table.entityName!}Details(@RequestBody OperationIdEntity operationidEntity) {

        return super.successMsg(EntityUtils.transform(${table.serviceAliasName}.view${table.entityName!}(operationidEntity.getId()), ${table.entityViewName}.class));
        }

        @ApiOperation(value = "删除${table.comment!}记录", httpMethod = "POST")
        @HibasePostRequestMapping(value = "/delete${table.entityName!}")
        public ResponseModel<String> delete${table.entityName!}(@RequestBody OperationIdEntity delete) {

            ${table.serviceAliasName}.delete${table.entityName!}(delete.getId());

            return super.successMsg();
            }
            }
            </#if>
