package calemi.fusionwarfare.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFusionShotgun extends ModelBase {

	ModelRenderer Shape1;
	ModelRenderer Shape2;
	ModelRenderer Shape3;
	ModelRenderer Shape4;
	ModelRenderer Shape6;
	ModelRenderer Shape7;
	ModelRenderer Shape9;
	ModelRenderer Shape10;
	ModelRenderer Shape11;
	ModelRenderer Shape12;
	ModelRenderer Shape13;
	ModelRenderer Shape14;
	ModelRenderer Shape8;

	public ModelFusionShotgun() {
		textureWidth = 64;
		textureHeight = 32;

		Shape1 = new ModelRenderer(this, 0, 0);
		Shape1.addBox(0F, 0F, 0F, 11, 2, 2);
		Shape1.setRotationPoint(-1F, 16F, 0F);
		Shape1.setTextureSize(64, 32);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
		Shape2 = new ModelRenderer(this, 0, 13);
		Shape2.addBox(0F, 0F, 0F, 2, 6, 1);
		Shape2.setRotationPoint(-2F, 16F, 0.5F);
		Shape2.setTextureSize(64, 32);
		Shape2.mirror = true;
		setRotation(Shape2, 0F, -0.0051637F, 0.2082002F);
		Shape3 = new ModelRenderer(this, 0, 4);
		Shape3.addBox(0F, 0F, 0F, 11, 1, 2);
		Shape3.setRotationPoint(-1F, 18F, 0F);
		Shape3.setTextureSize(64, 32);
		Shape3.mirror = true;
		setRotation(Shape3, 0F, 0F, 0F);
		Shape4 = new ModelRenderer(this, 0, 21);
		Shape4.addBox(0F, 0F, 0F, 2, 2, 1);
		Shape4.setRotationPoint(-3F, 15F, 0.5F);
		Shape4.setTextureSize(64, 32);
		Shape4.mirror = true;
		setRotation(Shape4, 0F, 0F, 0F);
		Shape6 = new ModelRenderer(this, 0, 7);
		Shape6.addBox(0F, 0F, 0F, 10, 1, 1);
		Shape6.setRotationPoint(10F, 16F, 0.5F);
		Shape6.setTextureSize(64, 32);
		Shape6.mirror = true;
		setRotation(Shape6, 0F, 0F, 0F);
		Shape7 = new ModelRenderer(this, 0, 9);
		Shape7.addBox(0F, 0F, 0F, 9, 1, 1);
		Shape7.setRotationPoint(10F, 17F, 0.5F);
		Shape7.setTextureSize(64, 32);
		Shape7.mirror = true;
		setRotation(Shape7, 0F, 0F, 0F);
		Shape9 = new ModelRenderer(this, 8, 15);
		Shape9.addBox(0F, 0F, 0F, 1, 1, 1);
		Shape9.setRotationPoint(8F, 15F, 0.5F);
		Shape9.setTextureSize(64, 32);
		Shape9.mirror = true;
		setRotation(Shape9, 0F, 0F, 0F);
		Shape10 = new ModelRenderer(this, 8, 13);
		Shape10.addBox(0F, 0F, 0F, 2, 1, 1);
		Shape10.setRotationPoint(0F, 17F, 1.3F);
		Shape10.setTextureSize(64, 32);
		Shape10.mirror = true;
		setRotation(Shape10, 0F, 0F, 0F);
		Shape11 = new ModelRenderer(this, 8, 13);
		Shape11.addBox(0F, 0F, 0F, 2, 1, 1);
		Shape11.setRotationPoint(0F, 17F, -0.3F);
		Shape11.setTextureSize(64, 32);
		Shape11.mirror = true;
		setRotation(Shape11, 0F, 0F, 0F);
		Shape12 = new ModelRenderer(this, 14, 13);
		Shape12.addBox(0F, 0F, 0F, 1, 1, 1);
		Shape12.setRotationPoint(3F, 17F, 1.266667F);
		Shape12.setTextureSize(64, 32);
		Shape12.mirror = true;
		setRotation(Shape12, 0F, 0F, 0F);
		Shape13 = new ModelRenderer(this, 14, 13);
		Shape13.addBox(0F, 0F, 0F, 1, 1, 1);
		Shape13.setRotationPoint(3F, 17F, -0.3F);
		Shape13.setTextureSize(64, 32);
		Shape13.mirror = true;
		setRotation(Shape13, 0F, 0F, 0F);
		Shape14 = new ModelRenderer(this, 0, 24);
		Shape14.addBox(0F, 0F, 0F, 2, 3, 1);
		Shape14.setRotationPoint(7F, 19F, 0.5F);
		Shape14.setTextureSize(64, 32);
		Shape14.mirror = true;
		setRotation(Shape14, 0F, 0F, 0F);
		Shape8 = new ModelRenderer(this, 0, 11);
		Shape8.addBox(0F, 0F, 0F, 9, 1, 1);
		Shape8.setRotationPoint(-1F, 15.7F, 0.5F);
		Shape8.setTextureSize(64, 32);
		Shape8.mirror = true;
		setRotation(Shape8, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Shape1.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
		Shape4.render(f5);
		Shape6.render(f5);
		Shape7.render(f5);
		Shape9.render(f5);
		Shape10.render(f5);
		Shape11.render(f5);
		Shape12.render(f5);
		Shape13.render(f5);
		Shape14.render(f5);
		Shape8.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}

}
