package core;

public abstract class BasicEntity implements IBasicEntity {
    protected Integer id;

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return this.id;
    }
}
