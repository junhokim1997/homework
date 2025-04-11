package Fri_04_02;

import java.util.Scanner;

public class Rpg_game {

	static int hero_level, hero_power, hero_hp, hero_defense, hero_mp, hero_experience, hero_money;
	static int monster_hp, monster_defense, monster_power, monster_mp, monster_level, monster_experience, monster_money;
	static String hero_name, monster_name;
	static boolean super_skill_type;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		hero_level = 1;
		hero_power = 5;
		hero_defense = 25;
		hero_hp = 100;
		hero_mp = 300;
		hero_experience = 0;
		hero_money = 1000;
		System.out.println("영웅의 이름을 입력하세요 :");
		hero_name = in.next();
		System.out.println("이름이 입력되었습니다.");
		System.out.println("게임에 입장하셧습니다.");
		hero_inform();

		while (true) {

			System.out.println("1. 사냥터");
			System.out.println("2. 잡화점");
			System.out.println("3. 캐릭터 정보조회");
			int menu1 = in.nextInt();

			if (menu1 == 1) {
				System.out.println("사냥터에 입장하셧습니다.");
				System.out.println("상대할 몬스터를 고르세요 : 1. Lv1 너구리 2. Lv5 살쾡이 3. Lv??? 꿀꿀이 대마왕");
				if (hero_level == 5) {
					System.out.println("살쾡이 사냥터에 입장가능 합니다.");
				}
				int monster_type = in.nextInt();
				if (monster_type == 1) {
					monster_name = "Lv1 너구리";
					System.out.println(monster_name + "와 전투 시작 - 선공");
					System.out.println("1. 기본 공격");

					int skil_number = in.nextInt();
					if (skil_number == 1) {

						monster_experience = 50;
						monster_money = 50;
						monster_level = 1;
						monster_power = 5;
						monster_defense = 5;
						int monster_hp = 900;
						out: while (monster_hp > 0) {
							int damage = hero_attack(hero_level, hero_power);
							System.out.println(monster_name + "에게 데미지" + damage + "를 입혔습니다");
							int damage2 = monster_attack(monster_level, monster_power);
							if (damage2 == 0) {
								hero_inform(monster_experience, monster_money);
								break out;
							}
							monster_hp = monster_hp - damage;
							System.out.println(monster_name + "의 현재 체력은" + (monster_hp) + "입니다.");
							System.out.println(monster_name + "가" + hero_name + "에게" + damage2 + "데메지를 입혔습니다");
							hero_hp = hero_hp - damage2;
							System.out.println(hero_name + "님의 현재 체력은" + (hero_hp) + "입니다.");

							if (monster_hp <= 0 && hero_hp > 0) {
								System.out.println("너구리가 죽었습니다");
								monster_hp = 900;
								hero_inform(monster_experience, monster_money);

								break;
							} else if (hero_hp <= 0) {
								System.out.println("영웅이 죽었습니다");
								System.out.println(
										"**********************************영웅이 다시 부활했습니다.*******************************");
								hero_inform(50);

								break out;

							}
						}
					}

				} else if (monster_type == 2) {
					monster_name = "Lv5 살쾡이";
					System.out.println(monster_name + "와 전투 시작 - 선공");
					System.out.println("1. 기본공격");
					int skil_number = in.nextInt();
					if (skil_number == 1) {
						monster_experience = 100;
						monster_money = 100;
						monster_level = 5;
						monster_power = 20;
						monster_defense = 50;
						int monster_hp = 4500;
						out: while (monster_hp > 0) {
							int damage = hero_attack(hero_level, hero_power);
							System.out.println(monster_name + "에게 데미지" + damage + "를 입혔습니다");
							int damage2 = monster_attack(monster_level, monster_power);
							if (damage2 == 0) {
								hero_inform(monster_experience, monster_money);
								break out;
							}
							monster_hp = monster_hp - damage;
							System.out.println(monster_name + "의 현재 체력은" + (monster_hp) + "입니다.");
							System.out.println(monster_name + "가" + hero_name + "에게" + damage2 + "데메지를 입혔습니다");
							hero_hp = hero_hp - damage2;
							System.out.println(hero_name + "님의 현재 체력은" + (hero_hp) + "입니다.");

							if (monster_hp <= 0 && hero_hp > 0) {
								System.out.println("살쾡이가 죽었습니다");
								monster_hp = 4500;
								hero_inform(monster_experience, monster_money);

								break;
							} else if (hero_hp <= 0) {
								System.out.println("영웅이 죽었습니다");
								System.out.println(
										"**********************************영웅이 다시 부활했습니다.*******************************");
								hero_inform(50);

								break out;

							}
						}
					}
				} else if (monster_type == 3) {
					// 보스
					monster_defense = 9999;
					monster_hp = 10000;
					if (super_skill_type) {
						System.out.println("1. 필살 초각성기를 사용");
						int num = in.nextInt();
						if (num == 1 && hero_mp >= 300) {
							hero_mp = 0;
							hero_attack(super_skill_type);
							System.out.println(hero_attack(super_skill_type) + "데미지를 꿀꿀이 대마왕에게 입혀 물리쳤습니다.");
							System.out.println("10000원과 10레벨을 획득하였습니다");
							hero_money += 10000;
							hero_level += 10;
							hero_inform();
							System.out.println("게임에서 승리하여 평화가 찾아왔습니다.!");
							break;

						} else if (hero_mp < 300) {
							System.out.println("mp가 300이 필요합니다. 현재 mp는" + hero_mp);

						}
					} else {
						System.out.println("필살 초각성기가 없이 꿀꿀이 대마왕을 죽일수 없습니다.");
						System.out.println("사용자가 죽었습니다");
						hero_hp = 50;
						hero_inform();
					}

				} else {
					System.out.println("1,2,3을 입력하십시오");

				}
			} else if (menu1 == 2) {
				// 잡화점
				System.out.println("잡화점 입니다");
				portion_market();

			} else if (menu1 == 3) {
				hero_inform();

			}
		}

	}

	static void hero_inform() {
		String type = "";
		if (super_skill_type)
			type = "보유중";
		else
			type = "없음";
		System.out.println("**************************");
		System.out.println("현재 " + hero_name + "의 이름 : " + hero_name);
		System.out.println("현재 " + hero_name + "의 레벨 : " + hero_level);
		System.out.println("현재 " + hero_name + "의 힘 : " + hero_power);
		System.out.println("현재 " + hero_name + "의 방어력: " + hero_defense);
		System.out.println("현재 " + hero_name + "의 HP: " + hero_hp);
		System.out.println("현재 " + hero_name + "의 MP : " + hero_mp);
		System.out.println("현재 " + hero_name + "의 경험치 : " + hero_experience);
		System.out.println("현재 " + hero_name + "의 돈: " + hero_money);
		System.out.println("현재 " + hero_name + "초각성기 유무 : " + type);
		System.out.println("***************************");

	}

	static void portion_market() {
		int str = 30;
		int arm = 30;
		int exp = 100;
		int hp = 10;
		int mp = 10;
		int super_skill = 999;
		System.out.println("************************************");
		System.out.println("현재" + hero_name + "님의 돈은" + hero_money + "입니다.");
		System.out.println("************************************");
		System.out.println("포션 상점에 입장 하였습니다.");
		System.out.printf("1. 힘 증강 포션 (%d)원\n", str);
		System.out.printf("2. 방어력 증강 포션 (%d)원\n", arm);
		System.out.printf("3. 경험치 증강 포션 (%d)원\n", exp);
		System.out.printf("4. HP 증강 포션 (%d)원\n", hp);
		System.out.printf("5. MP 증강 포션 (%d)원\n", mp);
		System.out.printf("6. 초각성기 습득 (%d)원\n", super_skill);
		Scanner in = new Scanner(System.in);
		System.out.println("원하시는 물건을 입력하세요 : ");
		int number = in.nextInt();
		int integ = 0;
		switch (number) {
		case 1 -> integ += str;
		case 2 -> integ += arm;
		case 3 -> integ += exp;
		case 4 -> integ += hp;
		case 5 -> integ += mp;
		case 6 -> integ += super_skill;
		}

		if (hero_money - integ > 0) {
			hero_money -= integ;
			System.out.printf("구입이 완료되었습니다 현재 잔액은 : %d 원입니다.\n", hero_money);
			switch (number) {
			case 1 -> hero_power += 3;
			case 2 -> hero_defense += 3;
			case 3 -> hero_experience += 50;
			case 4 -> hero_hp += 50;
			case 5 -> hero_mp += 50;
			case 6 -> super_skill_type = true;

			}
		} else {
			System.out.println("잔액 부족입니다.");
		}
	}

	static void hero_inform(int reset) {

		System.out.println("**************************");
		System.out.println("현재 " + hero_name + "의 이름 : " + hero_name);
		System.out.println("현재 " + hero_name + "의 레벨 : " + hero_level);
		System.out.println("현재 " + hero_name + "의 힘 : " + hero_power);
		System.out.println("현재 " + hero_name + "의 방어력: " + hero_defense);
		System.out.println("현재 " + hero_name + "의 HP: " + hero_hp);
		System.out.println("현재 " + hero_name + "의 MP : " + hero_mp);
		System.out.println("현재 " + hero_name + "의 경험치 : " + hero_experience);
		System.out.println("현재 " + hero_name + "의 돈: " + hero_money);
		System.out.println("***************************");

	}

	static void hero_inform(int exp, int money) {

		hero_experience += exp;
		hero_money += money;
		if (hero_experience < 100) {
			System.out.println("**************************");
			System.out.println("현재 " + hero_name + "의 이름 : " + hero_name);
			System.out.println("현재 " + hero_name + "의 레벨 : " + hero_level);
			System.out.println("현재 " + hero_name + "의 힘 : " + hero_power);
			System.out.println("현재 " + hero_name + "의 방어력: " + hero_defense);
			System.out.println("현재 " + hero_name + "의 HP: " + hero_hp);
			System.out.println("현재 " + hero_name + "의 MP : " + hero_mp);
			System.out.println("현재 " + hero_name + "의 경험치 : " + hero_experience);
			System.out.println("현재 " + hero_name + "의 돈: " + hero_money);
			System.out.println("***************************");

		} else {
			hero_experience = 0;
			hero_level += 1;
			hero_hp = hero_level * 80;
			hero_power += 15;
			hero_mp += 50;
			hero_defense += 25;
			System.out.println("레벨이 :" + hero_level + "레벨 되었습니다");
			System.out.println("레벨업 기념으로 돈이 100원 증가하여");
			hero_money += 100;
			System.out.println(hero_money + "원이 되었습니다");
			hero_inform();
		}

	}

	static int hero_attack(int hero_level, int hero_power) {
		int damage = (hero_level * 10 + hero_power * 30) - monster_defense;
		if (damage > 0) {
			return damage;

		} else {
			return 0;
		}

	}

	static int monster_attack(int monster_level, int monster_power) {
		int damage = (monster_level * 5 + monster_power * 5) - hero_defense;
		if (damage > 0) {
			return damage;
		} else {
			return 0;
		}
	}

	static int hero_attack(boolean trues) {
		if (trues)
			return 99999999;
		else
			System.out.println("스킬이없습니다.");
		return 0;

	}
}
