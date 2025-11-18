-- Script SQL para inserir dados de teste na tabela 'planos' (H2 Database)

-- 1. Plano Básico Mensal (Foco em Musculação/Cardio)
INSERT INTO planos (
    titulo, tipo, preco, descricao,
    opc_av_tecnica, opc_cardio, opc_musculacao,
    opc_coletivas_il, opc_coletivas_15, opc_av_fisica,
    opc_desconto_personal, status, metadata
) VALUES (
    'Plano Mensal Essencial', 'MENSAL', 99.90,
    'Acesso irrestrito à sala de musculação e área de cardio durante o horário de funcionamento.',
    FALSE, TRUE, TRUE,
    FALSE, FALSE, FALSE,
    FALSE, 'ON', '{"destaque":"false"}'
);

-- 2. Plano Anual Premium (Todas as Vantagens - DESTAQUE)
INSERT INTO planos (
    titulo, tipo, preco, descricao,
    opc_av_tecnica, opc_cardio, opc_musculacao,
    opc_coletivas_il, opc_coletivas_15, opc_av_fisica,
    opc_desconto_personal, status, metadata
) VALUES (
    'Plano Anual Total Power', 'ANUAL', 1199.90,
    'Acesso completo a todas as aulas, avaliações e descontos em serviços premium. O melhor custo-benefício.',
    TRUE, TRUE, TRUE,
    TRUE, FALSE, TRUE,
    TRUE, 'ON', '{"destaque":"true", "economia":"20%"}'
);

-- 3. Pacote de Sessões Avulsas (Para testes ou visitantes)
INSERT INTO planos (
    titulo, tipo, preco, descricao,
    opc_av_tecnica, opc_cardio, opc_musculacao,
    opc_coletivas_il, opc_coletivas_15, opc_av_fisica,
    opc_desconto_personal, status, metadata
) VALUES (
    'Sessão Diária Avulsa', 'SESSAO', 45.00,
    'Válido para 1 dia de acesso a Musculação e Cardio. Sem aulas coletivas.',
    FALSE, TRUE, TRUE,
    FALSE, FALSE, FALSE,
    FALSE, 'ON', '{"limite":"1"}'
);

-- 4. Plano Semestral Intermediário (Com Aulas Coletivas Limitadas)
INSERT INTO planos (
    titulo, tipo, preco, descricao,
    opc_av_tecnica, opc_cardio, opc_musculacao,
    opc_coletivas_il, opc_coletivas_15, opc_av_fisica,
    opc_desconto_personal, status, metadata
) VALUES (
    'Plano Semestral Flex', 'SEMESTRAL', 589.90,
    'Acesso total + 15 aulas coletivas por mês (escolha livre).',
    FALSE, TRUE, TRUE,
    FALSE, TRUE, FALSE,
    FALSE, 'ON', '{"beneficio":"flexibilidade"}'
);

-- 5. Plano Coletivas Ilimitadas (Foco em Aulas de Grupo)
INSERT INTO planos (
    titulo, tipo, preco, descricao,
    opc_av_tecnica, opc_cardio, opc_musculacao,
    opc_coletivas_il, opc_coletivas_15, opc_av_fisica,
    opc_desconto_personal, status, metadata
) VALUES (
    'Plano Aulas Ilimitadas', 'MENSAL', 159.90,
    'Perfeito para quem ama aulas de grupo: Jump, Dança, Yoga e mais, sem limites.',
    FALSE, FALSE, FALSE,
    TRUE, FALSE, FALSE,
    FALSE, 'ON', '{"foco":"aulas"}'
);

-- 6. Plano Off (Exemplo de plano desativado, não deve aparecer no site)
INSERT INTO planos (
    titulo, tipo, preco, descricao,
    opc_av_tecnica, opc_cardio, opc_musculacao,
    opc_coletivas_il, opc_coletivas_15, opc_av_fisica,
    opc_desconto_personal, status, metadata
) VALUES (
    'Plano Teste Antigo', 'MENSAL', 0.00,
    'Este plano está desativado para novos cadastros.',
    FALSE, FALSE, FALSE,
    FALSE, FALSE, FALSE,
    FALSE, 'OFF', '{}'
);