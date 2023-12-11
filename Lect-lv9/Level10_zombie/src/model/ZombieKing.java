package model;

import controller.Game;
import model.Zombie;

public class ZombieKing extends Unit {		//����ŷŬ������ ����Ŭ������ ����� �޴��ڽ�Ŭ�����̴�.
	private int shield;	
	private boolean isDead;
	private int dam;//������ ������ �߰��Ѵ�.
	public ZombieKing(String name, int hp, int att, int def, int position, int shield) {// ������ ����տ� GAME���� ���� ������� ������ ���ڷ��ش�.
		super(name, hp, att, def, position);		//�θ�Ŭ������ ���ڷ� ���� ������� ������ super�� �θ�Ŭ������ �����ڿ� ���ٽ�Ų��.
		this.shield = shield;					//���ڷ� ���� ���带 ������� ���庯���� �����Ѵ�.
	}
	public int getShield() {					//���ͷ� �����ġ ���
		return this.shield;
	}
	public void setShield(int shield) {			//���ͷ� �����ġ ����
		this.shield = shield;
	}
	public void attack(Unit target) {			//���ݸ޼ҵ忡 ����Ŭ������ �ڷ������� �޴� Ÿ���� ���ڷ� ������
		if(rand.nextInt(100)>74) {				//���� ������ 100�� ������ 74���� ū���� ������
			int dam = (this.getAtt() - target.getDef())*(rand.nextInt(150)+50)/100; //�������� Unit�� ���ݰ� ���� ����� ���� ���ϱ� ������ 150�� ������ ���� ��+50������ 100
			if(dam <= 0 ) {						//�������� 0 �����̸�
				dam = 1;						//�������� 1�̵ȴ�.
				
			}
			dam*=2;												
			System.out.println(getName()+"�� �ʻ��!!");				//����ŷ�� �ʻ������Ҷ� ��¹�
			System.out.println(dam+"�� ������");						//������ �����
			target.setHp(target.getHp()-dam);						//�������� �޴� ����� ü���� ����� ü��-�������� �����Ѵ�.
			System.out.println(target.getName()+"�� ����ü�� : "+target.getHp());		//�������� ���� ����� ü���� ����Ѵ�.
			
		}
		else {
			super.attack(target);
		}
	}
//	@Override
//	public void attack(Unit target) {
//		if(rand.nextInt(100)>74) {				//���� ������ 100�� ������ 74���� ū���� ������
//			this.dam = (this.getAtt() - target.getDef())*(rand.nextInt(150)+50)/100; //�������� Unit�� ���ݰ� ���� ����� ���� ���ϱ� ������ 150�� ������ ���� ��+50������ 100
//			if(this.dam <= 0 ) {						//�������� 0 �����̸�
//				this.dam = 1;						//�������� 1�̵ȴ�.
//				
//			}
//			this.dam*=2;												
//			System.out.println(this.getName()+"�� �ʻ��!!");				//����ŷ�� �ʻ������Ҷ� ��¹�
//			System.out.println(this.dam+"�� ������");						//������ �����
//			target.setHp(target.getHp()-dam);						//�������� �޴� ����� ü���� ����� ü��-�������� �����Ѵ�.
//			System.out.println(target.getName()+"�� ����ü�� : "+target.getHp());		//�������� ���� ����� ü���� ����Ѵ�.
//			((Player)target).damage(this.dam);
//		}
//		else {
////			super.attack(target);
//			this.dam = (this.getAtt()- target.getDef())*(Game.rand.nextInt(150)+50)/100;
//			if(this.dam <= 0) {
//				this.dam = 1;
//			}
//			System.out.printf("%s�� ����!\n", this.getName());
//			System.out.printf("%d�� ������!\n", dam);
//			((Player) target).damage(this.dam);
//		}
//		
//	}
//	@Override
//	public void damage(int attack) {
//		this.setHp(this.getHp()-attack);
//		System.out.println(this.getName()+"�� ����ü��: "+this.getHp());
//		if(this.getHp()<= 0) {
//			isDead = true;
//			System.out.println("������ ���...");
//		}
//		
//	}
}
