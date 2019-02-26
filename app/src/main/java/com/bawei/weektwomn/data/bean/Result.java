package com.bawei.weektwomn.data.bean;

import java.util.List;

/**
 * @author Alex
 * @date 2019/2/18.
 * GitHub：https://github.com/wangshuaialex
 */
public class Result {
    private List<Rxxp> rxxp ;

    private List<Pzsh> pzsh ;

    private List<Mlss> mlss ;

    public void setRxxp(List<Rxxp> rxxp){
        this.rxxp = rxxp;
    }
    public List<Rxxp> getRxxp(){
        return this.rxxp;
    }
    public void setPzsh(List<Pzsh> pzsh){
        this.pzsh = pzsh;
    }
    public List<Pzsh> getPzsh(){
        return this.pzsh;
    }
    public void setMlss(List<Mlss> mlss){
        this.mlss = mlss;
    }
    public List<Mlss> getMlss(){
        return this.mlss;
    }
}
